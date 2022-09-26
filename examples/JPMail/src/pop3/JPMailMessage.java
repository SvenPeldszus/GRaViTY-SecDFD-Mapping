/**
 * 
 */
package pop3;

import java.io.PrintStream;
import crypto.Ciphertext;
import crypto.DES;
import crypto.DESClosure;
import crypto.AES;
import crypto.AESClosure;
import crypto.RSAClosure;
import jif.lang.PrincipalUtil;
import smtp.EmailDisclaimerClosure;

import java.security.Key;
import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import policy.KeyPrincipal;

/**
 * @author phicks
 *
 */

public class JPMailMessage {
	/* == Data Fields ================================================ */
	protected final MimeHeader header;
	protected final String originalBody; // this is labeled uniformly; it will be transformed into a body marked for the
											// recipient
	protected final String body;
											private Principal rcptP;

	/* == Constructors =============================================== */
//     public MailHeader() 
//     {
// 	// do nothing
//     }

	/**
	 * intuitively, *lbl should be higher than , so it should be fine to have the
	 * function-label set at *rcptLbl
	 */
	public JPMailMessage(String toAddress, String fromAddress, String sendDate, String subject, String rcptLblStr,
			Principal p, String originalBody, String body) {
		header = new MimeHeader(toAddress, fromAddress, sendDate, subject, rcptLblStr, null); // no crypto, so null
		this.rcptP        = p;  // should hold that lbl <= {rcptP:} or we have problems
		this.originalBody = originalBody;
		this.body = body;
	}

	public JPMailMessage(MimeHeader mh, String rcptLblStr, Principal p, String originalBody, String body) {
		header = mh;
		this.rcptP = p;
		this.originalBody = originalBody;
		this.body = body;
	}

	public String getToAddress() {
		return header == null ? null : header.getToAddress();
	}


    public Principal getRcptP() {
    		return this.rcptP;
    	}

	public String getFromAddress() {
		return header == null ? null : header.getFromAddress();
	}

	public String getSubject() {
		return header == null ? null : header.getSubject();
	}

	public String getSendDate() {
		return header == null ? null : header.getSendDate();
	}

	public String getRcptLblStr() {
		return header == null ? null : header.getLabelStr();
	}

	public String getOriginalBody() {
		return this.originalBody;
	}

	public String getBody() {
		return this.body;
	}

	/** converts a JPMailMessage to MailMessage by encrypting the body
     *  everything should be at the level of  when we finish
     *  then  can be converted by some other means
     *  maybe rcptP should be a member of the class? -- it is now
     * BAD: not sure if we really want the {} side-effect label!
	 * @param rcptP 
     * @param rcptP is a principal that can authorize the declassifying encryption of the body (i.e. rcptLbl <= )
     * @param lbl is the level at which to output this message
     * @return Newly constructed MimeMailMessage which contains the body text encrypted along with the key and IV and the header
     */
    public MimeMailMessage toMimeMailMessage(PrintStream debug, Principal user)
	{
    		if (debug != null) debug.println("ENTERING toMimeMailMessage...");
		MimeMailMessage mmm = null;

    	// need to get the principal(s) out of rcptLbl
    		if (true) {
    			boolean success = true; // presume it will work, but, if not, set flag

    			String disclaimerBody = "";
    			EmailDisclaimerClosure edc = new EmailDisclaimerClosure(getBody());
    			try {
    				disclaimerBody = (String)PrincipalUtil.authorize(rcptP, null,edc).invoke();
    			} catch (ClassCastException ignore) {
    			} catch (NullPointerException e) { success = false; } // failed to authorize

    			if (success) {
    				final MimePart[] parts = new MimePart[1];

	    			try {
	    				parts[0] = MimePart.make7bitPart(disclaimerBody,true,header);
	    				mmm = new MimeMailMessage(header,parts,1);
		    		} catch (NullPointerException ignore) { 
		    		} catch (ArrayIndexOutOfBoundsException ignore) { // shouldn't happen
		    		} catch (ArrayStoreException ignore) {} // not sure what this is
    			} else {
    				if (debug != null) debug.println("Trying encryption.");
    				// common for all encryption types
    				String crypto = "none";  // presume no encryption
				Key key = null;
	    			Ciphertext encBody = null;
	    			// upgrade and copy the body so that it can be sent to DESClosure
	    			final String bodyStr = getBody(); // upgrade the label on the String
	    			final byte[] bodyBytes = bodyStr == null ? null : bodyStr.getBytes();

	    		// ---try AES---
	    			success = true;
	    			crypto = "AES";
				try {
					key = AES.getNewKey();
				} catch (NoSuchAlgorithmException impossible) {
				} catch (NullPointerException impossible) {}

				if (debug != null) debug.println("Trying AES...");
	    			AESClosure ac = new AESClosure(key,bodyBytes);    			
	    			try {
	    				encBody = (Ciphertext)PrincipalUtil.authorize(rcptP, null,ac).invoke();
	    			} catch (ClassCastException ignore) {
	    			} catch (NullPointerException ignore) { success = false; } // means we didn't get authorization
	    			if (!success) {
	    		// ---try DES---
	    				success = true;
	    				crypto = "DES";
					try {
						key = DES.getNewKey();
					} catch (NoSuchAlgorithmException impossible) {
					} catch (NullPointerException impossible) {}

					if (debug != null) debug.println("Trying DES...");
		    			DESClosure dc = new DESClosure(key,bodyBytes);    			
		    			try {
		    				encBody = (Ciphertext)PrincipalUtil.authorize(rcptP, null,dc).invoke();
		    			} catch (ClassCastException ignore) {
		    			} catch (NullPointerException ignore) { success = false; } // means we didn't get authorization
	    			}	    				

	    			if (!success) {
	    				crypto = "failed";
					final MimeHeader cryptoHeader = header != null ? header.addCrypto(crypto) : null;   // add whatever crypto we used.
		    			final MimePart[] parts = new MimePart[1];
		    			try {
		    				parts[0] = MimePart.make7bitPart("<CANNOT DISCLOSE BODY>",true,cryptoHeader);
			    		} catch (NullPointerException ignore) { // caused by key.getEncoded or encBody.*
			    		} catch (ArrayIndexOutOfBoundsException ignore) { // shouldn't happen
			    		} catch (ArrayStoreException ignore) {} // not sure what this is
		    			mmm = new MimeMailMessage(cryptoHeader,parts,3);
	    			} else { // able to encrypt in some way so package up the key and IV with the ciphertext in the MimeBody
					byte[] keyBits1 = null;
			
					try {
						keyBits1 = key.getEncoded();
					} catch (NullPointerException ignore) {}
			
			// encrypt and add key to MimeMailMessage

			// we only need to declassify because we didn't encrypt yet -- should be removed eventually -- DONE
//					DeclassKeyClosure dkc = new DeclassKeyClosure(keyBits1);
					PublicKey rcptKey = null;
					if (rcptP instanceof KeyPrincipal) {
						rcptKey = ((KeyPrincipal)rcptP).getPublicKey();
					}
					
					RSAClosure rsaClo = new RSAClosure(rcptKey,keyBits1);
					byte[] keyBits = null;
					
					try {
						keyBits = ((Ciphertext)PrincipalUtil.authorize(rcptP,null,rsaClo).invoke()).encText;
					} catch (NullPointerException ignore) {  // would mean the authorization failed
					} catch (ClassCastException ignore) {} 
	    	
	    	// create the Message
			
					final MimeHeader cryptoHeader = header != null ? header.addCrypto(crypto) : null;   // add whatever crypto we used.
		    			final MimePart[] parts = new MimePart[3];
		
		    			try {
			    			parts[0] = MimePart.makeBase64Attachment("key",keyBits,false,cryptoHeader);
			    			//if (parts != null && parts[0] != null && outS != null) outS.println("Made the first part -- KEY"); 
			    			// add IV to MimeMailMessage
			    			parts[1] = MimePart.makeBase64Attachment("iv",encBody.iv,false,cryptoHeader);
			    			//if (parts != null && parts[1] != null && outS != null) outS.println("Made the second part -- IV"); 
			    			// add encrypted body to MimeMailMessage
			    			parts[2] = MimePart.makeBase64Attachment("body",encBody.encText,true,cryptoHeader);
			    			mmm = new MimeMailMessage(cryptoHeader,parts,3);
			    		} catch (NullPointerException ignore) { // caused by key.getEncoded or encBody.*
			    		} catch (ArrayIndexOutOfBoundsException ignore) { // shouldn't happen
			    		} catch (ArrayStoreException ignore) {} // not sure what this is
			    	}
		    	}
    		}
    		return mmm;
    }

// 	public void setBody(String body) {
// 		this.body = body;
// 	}

}
