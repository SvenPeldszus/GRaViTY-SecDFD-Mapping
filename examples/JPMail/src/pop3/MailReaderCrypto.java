/* *****************************************************************************
*
*   FILE          :MailReaderCrypto.jif
*   Project       :JPmail
*   Description   :Main file for reading email using POP3
*				  
*   Last Modified :Mon Apr 10 17:35:48 EDT 2006
*
*  Copyright (c) 2006 The Pennsylvania State University
*  Systems and Internet Infrastructure Security Laboratory
*
******************************************************************************/
package pop3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.PrintStream;
import java.util.StringTokenizer;
//import java.util.Vector;

//import javax.mail.internet.MailDateFormat;
import javax.net.SocketFactory;
//import javax.net.ssl.SSLSocketFactory;
import jif.net.JifSocketFactory;

import java.security.PrivateKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import policy.PolicyStore;
import policy.JifPolicy;
import policy.KeyPrincipal;

import crypto.Ciphertext;
import crypto.DES;
import crypto.AES;
import crypto.RSA;

import smtp.DigestMD5;

/**
 * @author phicks
 *
 */
public class MailReaderCrypto {
	/* == Class Global Data ========================================== */
	final private String mailhost, username;
	final private char[] password;
	final private int mailport;
	final private boolean isSSL;
	private int messageCount;
	private int currentMessage;

    final public Principal SocketP;
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;
	protected boolean isConnected;

	final private PolicyStore policy;
    final public Principal debugP;
	final PrintStream debug;

	public static final String POP3_PORT = "110"; // default POP3 port
	public static final String POPS_port = "995"; // default POP3 SSL port
	private static final int INVALID_MESG_COUNT = -1;

	/** Constructor
     * @param host host name
     * @param name user name
     * @param pass password (should be high secrecy)
     * @param port port number
     * @param ssl whether it is an SSL connection
     */
    MailReaderCrypto(String host, String name, char[] pass, int port, boolean ssl,
		       PolicyStore policy, Principal debugP, PrintStream debug)
    {
    	this.debugP = debugP;
		this.policy = policy;
		this.debug = debug;
		mailhost = host;
		username = name;
		password = pass;
		mailport = port;
		isSSL = ssl;
		isConnected = false;
		if (!isSSL) {
			SocketP = null;  // this makes it public
//			SocketL = new label{};
		}
		else {
			SocketP = null; // Owner;  // Could make it Server-level with SSL enabled; but Owner works for now
//			SocketL = new label{Owner:};
		}
		isConnected = false;
		messageCount = INVALID_MESG_COUNT;
    }

	/** establishes connection if one does not already exist
     * side-effects: changes userString, passString, isConnected, opens a socket, reads from and writes to the socket
     * @throws IOException
     */
    public void connect() throws IOException
    {
//		 {
		if (true) {
			BufferedReader in = this.in; // use locals so NPE-analysis works
			PrintWriter out = this.out;
			
			String response = "";
			SocketFactory socketFactory = new JifSocketFactory();
			
			String userString = "user " + username;

			String pw = null;
			try {
				pw = new String(password);
			} catch (NullPointerException e) {}
			
// DECLASSIFICATION: need to declassify the password before sending it to the Socket			
//			String passString = "pass " + declassify(pw); 
		
			if (debug != null) {
			    //debug.println("Pass is: " + pw);
			    debug.println("username is: " + username);
			    debug.println("mailhost is: " + mailhost);
			}
			
			// No need to connect
			if (isConnected) {
			    return;
			}
	
	// Handle SSL properly
	//		if (isSSL) {
	//		    socketFactory = SSLSocketFactory[].getDefault();
	//		} else {
	//		    socketFactory = SocketFactory[].getDefault();
	//		}
	
			final Socket sock = socketFactory.createSocket(mailhost, mailport);
			this.sock = sock;
			
			// configure socket io streams
			if (sock != null) {
			    in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			    out = new PrintWriter(sock.getOutputStream(), true);
			}
			else if (debug != null) debug.println("Socket is null for some reason.");
			
			DigestMD5 mmd5 = null;
			try {
				mmd5 = new DigestMD5();
			} catch (NoSuchAlgorithmException nsae) {
			} catch (NoSuchProviderException nspe) {}
			
			final DigestMD5 md5 = mmd5;
			
			// log in
			String okLine = null;
			if (in != null && out != null) {
			    okLine = in.readLine();	    // consume welcome banner: e.g. "+OK POP3 server ready <1896.697170952@dbc.mtview.ca.us>"
			    if (debug != null) debug.println("okLine: " + okLine);

			    String apopChallenge = null;
			    if (md5 != null)	apopChallenge = md5.authAPOP(okLine);				// e.g. 1896.697170952@dbc.mtview.ca.us
			    if (debug != null) debug.println("APOP challenge: " + apopChallenge);

			    String digest = null;
			    if (md5 != null)	digest = md5.getAPOPDigest(pw,apopChallenge);
			    if (debug != null) debug.println("APOP digest: " + digest);

			    out.println("APOP " + username + " " + digest); // "APOP user MD5(<1896.697170952@dbc.mtview.ca.us>password"
			    response = in.readLine();	    // confirm APOP accepted: e.g. "+OK maildrop has 1 message (369 octets)"
			}
			else if (debug != null) debug.println("socket I/O is null for some reason");

/*			String okLine = null;
			if (in != null && out != null) {
			    okLine = in.readLine();	    // consume welcome banner
			    out.println(userString);            // send username
			    response = in.readLine();	    // consume "+OK plese send PASS command"
			    out.println(passString);            // send password
			    response = in.readLine();	    // confirm password accepted
			}
			else if (debug != null) debug.println("socket I/O is null for some reason");
*/		
			if (response != null) {
			    try {
					if (response.substring(0, 3).compareTo("+OK") != 0) {
					    if (debug != null) debug.println("Error: response is: " + response);
					}
			    }
			    catch (StringIndexOutOfBoundsException e) {}
			    catch (NullPointerException e) {}
			}
			
			isConnected = true;
			this.in = in;
			this.out = out;
			messageCount = INVALID_MESG_COUNT;
		}
    }

	/**
	 * closes the connection
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		try {
			sock.close();
		} catch (NullPointerException e) {
		} // ignore
		isConnected = false;
	}

	/**
	 * populates messageCount class global variable
	 * 
	 * @throws IOException
	 */
	private void countMessages() throws IOException {
		BufferedReader in = this.in; // use locals so NPE-analysis works
		PrintWriter out = this.out;

		String response = "";

//		if (!isConnected) {
//		    throw new IOException("not connected.");
//		}

		if (out != null)
			out.println("stat");
		// else if (outS != null) outS.println("output socket is null for some reason");

		if (in != null)
			response = in.readLine();
		// else if (outS != null) outS.println("input socket is null for some reason");

		// if (outS != null) outS.println("Count response: " + response);

		StringTokenizer token = new StringTokenizer(response);
		try {
			if ((token.countTokens() != 3) || (token.nextToken().compareTo("-ERR") == 0)) {
				throw new IOException("stat error: " + response);
			}
			messageCount = Integer.parseInt(token.nextToken());
		} catch (Exception e) {
		}
	}

	/**
	 * returns messageCount, calling countMessages() if necessary
	 * 
	 * @return number of messages
	 * @throws IOException
	 */
	public int getMessageCount() throws IOException {
//		if (!isConnected) {
//		    throw new IOException("not connected");
//		}

		if (messageCount == INVALID_MESG_COUNT) {
			this.countMessages();
		}

		return this.messageCount;
	}

	/** returns a MimeMessage at level of Owner or null if {message} >=  (not ownable by Owner)
     * @param index labeled as  even though it is private to the owner, it is going to be traveling out at SocketL anyway...
	 * @param rcptP 
     * @return labeled  bcs it will be safe to leave it even public, since body is correctly protected
     * @throws IOException
     */
    public JPMailMessage getJPMailMessage(int index)
    {
		BufferedReader in = this.in; // use locals so NPE-analysis works
		PrintWriter out = this.out;
	
		/*	if (index <= 0)
		    {
			//System.err.println("Invalid message number.  Must be >0.\n");
			return null;
		    }
		*/
	
		/*	if (!isConnected) {
		    return null;//throw new IOException("not connected.");
		}
		*/
		
		//FIXME: When we add SSL Sockets, this will need to change and copy in the OR-statement
		
		if (out != null) // || SocketL <= {SocketP:})  // foundational assumption which allows declass with SocketP's auth
		{
		    out.println("retr " + index);
	
			final MimeMailMessage mmm = MimeMailMessage.getMimeMailMessage(in);
			// presume the order of the body parts
			// 1: Key
			// 2: IV
			// 3: Ciphertext

//			
//				if (debug != null && mmm != null) debug.println("MimeMailMessage read in: " + mmm.toString());
				
			MimeHeader mh = mmm != null ? mmm.getMimeHeader() : null;
			if (mmm != null && mh != null && mh.getCrypto() != null && mmm.getNumParts() == 3) {
				final String rcptLblStr = mmm.getRcptLblStr();
				final Principal rcptP = policy == null ? null : policy.getPrincipal(mmm.getRcptLblStr());
				final Principal rcpt = rcptP;//policy == null ? null : policy.getPrincipal(mmm.getRcptLblStr(),new label{});
				if (rcpt == null) return null;
				 
				byte[] inKeyBits = null;

				try {
					inKeyBits = ((MimePartBase64)mmm.getMimeParts()[0].getMimePartBody()).getBody();
				} catch (NullPointerException ignore) { // each of these dereferences could cause this
				} catch (ClassCastException ignore) { // TODO:need to check this
				} catch (ArrayIndexOutOfBoundsException ignore) {}
				
// read in encrypted key; decrypt and upgrade with rcptP's PrivateKey
				int len = inKeyBits == null ? 0 : inKeyBits.length;
				
				PrivateKey rcptPrivateKey = null;

				try {
					if (rcptP instanceof KeyPrincipal)
						rcptPrivateKey = ((KeyPrincipal)rcptP).getPrivateKey();
				} catch (SecurityException e) { return null; } // means that private key is not accessible
				 
				String keyBitString = null;
				try {
					keyBitString = RSA.decrypt(rcptPrivateKey,new Ciphertext(inKeyBits));
				} catch (InvalidKeyException ignore) {
				} catch(IllegalBlockSizeException ignore) {
				} catch(BadPaddingException ignore) { 
				} catch(NoSuchPaddingException ignore) { 
				} catch(InvalidAlgorithmParameterException ignore) { 
				} catch(NoSuchAlgorithmException ignore) {
				} catch(NullPointerException ignore) {
				} catch(IllegalArgumentException ignore) {}
		 
				final String keyBitStr = keyBitString;
				final byte[] keyBits = keyBitStr != null ? keyBitStr.getBytes() : null;
				Key myKey1 = null;
				if (keyBits != null) myKey1 = new SecretKeySpec(keyBits,mh.getCrypto());  // should be "DES", "AES", etc.

// read in IV
				byte[] ivBits = null;			
				try {
					ivBits = ((MimePartBase64)mmm.getMimeParts()[1].getMimePartBody()).getBody();
				} catch (NullPointerException ignore) { // each of these dereferences could cause this
				} catch (ClassCastException ignore) { // TODO:need to check this
				} catch (ArrayIndexOutOfBoundsException ignore) {}
				
// read in encText
				byte[] bodyBits = null;			
				try {
					bodyBits = ((MimePartBase64)mmm.getMimeParts()[2].getMimePartBody()).getBody();				
				} catch (NullPointerException ignore) { // each of these dereferences could cause this
				} catch (ClassCastException ignore) { // TODO:need to check this
				} catch (ArrayIndexOutOfBoundsException ignore) {}

				final Ciphertext ciphertext2 = new Ciphertext(bodyBits,ivBits);
	
			// decryption
			    String bodyText = null;
			    try {
			    		if (mh.getCrypto().compareTo("DES") == 0) bodyText = (String)DES.decrypt(myKey1,ciphertext2);
			    		else if (mh.getCrypto().compareTo("AES") == 0) bodyText = (String)AES.decrypt(myKey1,ciphertext2);
			    	} catch (InvalidKeyException ex) {  //ignore these for now
			    	} catch (IllegalBlockSizeException ex) {
			    	} catch (BadPaddingException ex) {
			    	} catch (NoSuchPaddingException ex) {
			    	} catch (InvalidAlgorithmParameterException ex) { 
			    } catch (NoSuchAlgorithmException ex) {
			    } catch (NullPointerException ex) {}
	
			    //final MimeHeader mh = mmm.getMimeHeader();
				final JPMailMessage newMsg = new JPMailMessage(mh,
		 								 mmm.getRcptLblStr(),  // label string
		 								 rcpt,
		 								 null,
		 								 bodyText);  // body text labeled with rcptLbl)
			    
			    return newMsg;
				//declassify({}) 
	//			if (outS != null) outS.println("The decrypted string is: " + declassify(returnString, {}));
			}
	    }	   
	    return null;  // default if outS == null or mmm == null or SocketP/SocketL not correctly related
    }

	/**
	 * returns a message
	 * 
	 * @param index
	 * @return
	 * @throws IOException
	 */
	/*
	 * public void viewMessage(int index, PrintStream outS,principal user) where
	 * caller(Owner) { PrintStream outStream = outS; BufferedReader in = this.in; //
	 * use locals so NPE-analysis works PrintWriter out = this.out;
	 * 
	 * // if (index <= 0) // { //
	 * //System.err.println("Invalid message number.  Must be >0.\n"); // return; //
	 * } String response = null; String from = null; String subject = null; String
	 * date = null; String mail_label = null; String body = ""; boolean header =
	 * true;
	 * 
	 * // if (!isConnected) { // return;//throw new IOException("not connected.");
	 * // }
	 * 
	 * if (out != null) out.println("retr " + index);
	 * 
	 * // read in the fields from the message try { while (true) { try { response =
	 * in.readLine(); } catch (IOException e) {}
	 * 
	 * if (header && response.compareTo("") == 0) { header = false; continue; }
	 * 
	 * if (response.compareTo(".") == 0) { break; // end of data }
	 * 
	 * if (header) { if (response.startsWith("From: ")) { from =
	 * response.substring(6); // remove "From: " } if
	 * (response.startsWith("Subject: ")) { subject = response.substring(9); //
	 * remove "Subject: " } if (response.startsWith("Date: ")) { date =
	 * response.substring(6); // remove "Date: " } if
	 * (response.startsWith("X-Jif-Label: ")) { mail_label = response.substring(13);
	 * // remove "x-jif-label: " // outS.println("The label is: " + mail_label); } }
	 * else { body += response + "\n"; } } } catch (NullPointerException e) {} catch
	 * (StringIndexOutOfBoundsException e) {}
	 * 
	 * // get label corresponding to X-Jif-Label field // then apply it to the
	 * MailMessage
	 * 
	 * final label mesg_lbl = mail_label == null ? {} :
	 * convertLabel(mail_label);
	 * 
	 * MailMessage{*mesg_lbl;Owner:} mesg = new MailMessage(currentMessage, from,
	 * date, subject, body);
	 * 
	 * 
	 * // This is an issue. We need to be able to write the fields to the message //
	 * at the level of *lbl // This will require declassification // This is why we
	 * want a separate unit to do this reading // which knows how to translate from
	 * the Socket level to the user // depending on the label on the fields. if
	 * (mesg_lbl <= ) { if (outStream != null) if (user actsFor Owner) {
	 * outStream.println("The message is:"); outStream.println(mesg.getBody()); } }
	 * else if (outStream != null) if (user actsFor Owner)
	 * outStream.println("Message is too secret.  Can't read the message."); }
	 */
	/**
	 * only returns email address between < >
	 * 
	 * @param address takes an EMail address directly from a Message
	 * @return
	 */
//     private String emailFormat(String address)
//     {
// 		int open, close;
// 		String result = address;

// 		if ((open = address.indexOf('<')) != -1) {
// 		    if ((close = address.indexOf('>')) != -1) {
// 			result = address.substring(open+1, close);
// 		    }
// 		}

// 		return result;
//     }

	/**
	 * returns the date in the format we prefer
	 * 
	 * @param in The date in String format
	 * @return The date in simple date format
	 */
//     private String dateFormat(String in)
//     {
// 		MailDateFormat mf = new MailDateFormat();
// 		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
// 		Date date = null;

// 		// try to parse
// 		try {
// 		    date = mf.parse(in);
// 		} catch (ParseException e) { }

// 		if (date == null) {
// 		    return new String("(unknown)");
// 		} else {
// 		    return sdf.format(date);
// 		}
// 	}

	/**
	 * @param args
	 */
    public static void main(String[] args) {
		String mainPstr = null;
		try {
			mainPstr = args != null ? args[0] : "NEED TO ENTER USER PRINCIPAL NAME";
		} catch (ArrayIndexOutOfBoundsException e) {mainPstr = "NEED TO ENTER USER PRINCIPAL NAME"; return;}
		
		PolicyStore policy = null;
		try {
			policy = JifPolicy.setupPolicy(mainPstr);
		} catch (SecurityException e) {}
		
		Principal mainP = (policy != null) ? policy.getPrincipal(mainPstr) : null;
		final Principal me = mainP;

		jif.runtime.Runtime runtime = null;
		try {
			runtime = jif.runtime.Runtime.getRuntime();
		} catch (SecurityException e) {}

		PrintStream outS = null;
	 	try{
	 	    outS = runtime.stdout();
	 	}
	 	catch (SecurityException ex) {/* should do something here*/}
		catch (NullPointerException e) {}
	
		if (outS != null) {
			outS.println("=========Read in policy; loaded Runtime========");
			outS.println("Reading in password from password-pop3");
		}
		final char[] pw2 = util.Password.getPassword("password-pop3", me);
/*		byte[] pwBytes = (pw2 == null ? null : new byte[pw2.length]);
		try {
			for (int i = 0; i < pwBytes.length; i++) {
				pwBytes[i] = (byte)pw2[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (NullPointerException e) {}
*/		 
		String server = null;
		try {
			server = args != null ? args[1] : "NEED TO ENTER SERVER ADDRESS";
		} catch (ArrayIndexOutOfBoundsException e) {server = "NEED TO ENTER SERVER ADDRESS";}

		String myusername = null;
		try {
			myusername = args != null ? args[2] : "NEED TO ENTER USER NAME";
		} catch (ArrayIndexOutOfBoundsException e) {myusername = "NEED TO ENTER USERNAME";}

		final MailReaderCrypto pop = 
		    new MailReaderCrypto(server, myusername, pw2, 
		    								110, false, policy, me, null);
	
		if (outS != null) outS.println("Getting connection...");
	
	 	int numMsgs = 0;
	
	 	try {
	 		pop.connect(); // needed to pass on authority (only needed due to lack of SSL sockets)
	 	    numMsgs = pop.getMessageCount();
	 	}
	 	catch (IOException e) {}// if (outS != null) if (user actsFor me) outS.println("Failed to connect.");}

	 	if (outS != null) {
	 	    if (numMsgs == 1) {
	 	    		outS.println("There is 1 message.");
	 	    		outS.println("Printing 1 message:\n----------");
	 	    	}
	 	    else {
	 	    		outS.println("There are " + numMsgs + " messages.");
	 	    		outS.println("Printing " + numMsgs + " messages:\n----------");
	 	    }
	 	}

	 	 for (int i = 1; i <= numMsgs; i++) {
				if (outS != null) outS.println("Getting message " + i);
				final JPMailMessage msg = pop.getJPMailMessage(i);
				if (outS != null) {
					if (msg != null) {
						outS.println("From: " + msg.getFromAddress());
						outS.println("Subject: " + msg.getSubject());
					outS.println(msg.getBody());
					}
					else outS.println("Msg is NULL.");
				}
	 	 }
		try {
			pop.close();		// need to close so that someone else can open
		}
		catch (IOException e) {} // ignore
    }
}
