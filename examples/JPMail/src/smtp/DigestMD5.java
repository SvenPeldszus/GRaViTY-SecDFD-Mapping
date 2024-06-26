/* *****************************************************************************
*
*   FILE          :DigestMD5.jif
*   Project       :JPmail
*   Description   :Class for doing DIGEST-MD5 authentication in SMTP
*				  
*   Last Modified :Mon Apr 10 15:27:52 EDT 2006
*
*  Copyright (c) 2006 The Pennsylvania State University
*  Systems and Internet Infrastructure Security Laboratory
*
******************************************************************************/
package smtp;

import java.io.*;
import java.util.*;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;

import crypto.MD5Closure;
import jif.lang.PrincipalUtil;

/**
 * DIGEST-MD5 authentication support.  Jif-ized by Boniface Hicks
 *
 * @author Dean Gibson
 * @author Bill Shannon
 * @author Boniface Hicks
 */

public class DigestMD5 {

    //private PrintStream debugout;	// if not null, debug output stream
    final private MessageDigest md5;
    private String uri;
    private String clientResponse;

    public DigestMD5()  throws NoSuchAlgorithmException,NoSuchProviderException {
		//this.debugout = debugout;
		//if (debugout != null)
		//    debugout.println("DEBUG DIGEST-MD5: Loaded");
		this.md5 = MessageDigest.getInstance("MD5",new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    /**
     * Return client's authentication response to server's challenge.
     *
     * @return byte array with client's response
     */
    public byte[] authClient(String host, String user, String passwd, String realmInput, String serverChallenge, PrintStream debugout, Principal debugP)
				throws IOException 
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStream b64os = new BASE64EncoderStream(bos, Integer.MAX_VALUE);
		SecureRandom random = new SecureRandom();
		String realm = realmInput;
		
		final StringBuffer result = new StringBuffer();
		
		uri = "smtp/" + host;
		String nc = "00000001";
		String qop = "auth";
		byte[] bytes = new byte[32];	// arbitrary size ...
		int resp;
	
		if (debugout != null) debugout.println("DEBUG DIGEST-MD5: Begin authentication ...");
	
		// Code based on http://www.ietf.org/rfc/rfc2831.txt
		final Map map = tokenize(serverChallenge);
		if (map == null) {
			if (debugout != null) debugout.println("Couldn't tokenize map!");
			return null;
		}
		else {
			final Object r = map.get("realm");
			final Object n = map.get("nonce");
			final Object q = map.get("qop");
			final Object c = map.get("cipher");
			if (debugout != null) {
				debugout.println("realm --> " + (r != null ? r.toString() : "**"));
				debugout.println("nonce --> " + (n != null ? n.toString() : "**"));
				debugout.println("qop --> " + (q != null ? q.toString() : "**"));
				debugout.println("cipher --> " + (c != null ? c.toString() : "**"));
			}
		}
		
		if (realm == null) {
		    final Object jtext = map.get("realm");
		    final String text = jtext != null ? jtext.toString() : null;
		    final StringTokenizer stok = new StringTokenizer(text,",");
		    try {
		    		realm = (text != null && stok != null) ? stok.nextToken() : host;
		    } catch (NoSuchElementException ignore) { realm = host; }
		}
	
		// server challenge random value
		final Object jnonce = map.get("nonce");
		final String nonce = jnonce != null ? jnonce.toString() : null;
	
		random.nextBytes(bytes);
		b64os.write(bytes);
		b64os.flush();
	
		// client challenge random value
		String cnonce = bos.toString();
		bos.reset();
	
		if (debugout != null) debugout.println("My nonce is: " + cnonce);
		
		// DIGEST-MD5 computation, common portion (order critical)
		if (md5 == null) return null;
		final String input1 =  user + ":" + realm + ":" + passwd;
		final String input2 = ":" + nonce + ":" + cnonce;
		
// DECLASSIFICATION!!
		final MD5Closure md5clo= new MD5Closure(md5,input1);
		byte[] input1_declass = null;
		final Principal p = null;
		try {
			input1_declass = (byte[])PrincipalUtil.authorize(p,null,md5clo).invoke();
		} catch (NullPointerException e) {if (debugout != null && p != null) debugout.println("Authorization failed for " + p.getName());} //authorization failed
		
		md5.update(input1_declass); 
		md5.update(input2 != null ? input2.getBytes() : null);
		clientResponse = toHex(md5.digest()) + ":" + nonce  + ":" + nc + ":" + cnonce + ":" + qop + ":";
		
		if (debugout != null) debugout.println("Client RESPONSE to be: " + clientResponse);
		
		// DIGEST-MD5 computation, client response (order critical)
		final String input3 = "AUTHENTICATE:" + uri;
		md5.update(input3 != null ? input3.getBytes() : null);
		final String input4 = clientResponse + toHex(md5.digest());
		md5.update(input4 != null ? input4.getBytes() : null);
	
		// build response text (order not critical)
		result.append("username=\"" + user + "\"");
		result.append(",realm=\"" + realm + "\"");
		result.append(",qop=" + qop);
		result.append(",nc=" + nc);
		result.append(",nonce=\"" + nonce + "\"");
		result.append(",cnonce=\"" + cnonce + "\"");
		result.append(",digest-uri=\"" + uri + "\"");
		result.append(",response=" + toHex(md5.digest()));

		String resultStr = result != null ? result.toString() : null;
	
		if (debugout != null) debugout.println("DEBUG DIGEST-MD5: Response => " + resultStr);
		
		b64os.write(resultStr != null ? resultStr.getBytes() : null);
		b64os.flush();
		return bos.toByteArray();
    }

    /**
     * Allow the client to authenticate the server based on its
     * response.
     *
     * @return	true if server is authenticated
     */
    public boolean authServer(String serverResponse, Principal debugP) //, PrintStream debugout) 
    throws IOException {
    		final Map map = tokenize(serverResponse);
    		
		// DIGEST-MD5 computation, server response (order critical)
		final String input1 = ":" + uri;
		if (md5 != null) md5.update(input1 != null ? input1.getBytes() : null);
		final String input2 = clientResponse + toHex(md5 != null ? md5.digest() : null);
		if (md5 != null) md5.update(input2 != null ? input2.getBytes() : null);
		final String text = toHex(md5 != null ? md5.digest() : null);
		final Object rspAuthVal = map != null ? map.get("rspauth") : null;
		if (text != null ? (!text.equals(rspAuthVal != null ? rspAuthVal.toString() : null)) : true) {
		    //if (debugout != null)
			//debugout.println("DEBUG DIGEST-MD5: " +
			//	    "Expected => rspauth=" + text);
		    return false;	// server NOT authenticated by client !!!
		}
		return true;
    }

    /**
     * Tokenize a response from the server.
     *
     * @return	Hashtable containing key/value pairs from server
     */
    private Map tokenize(String serverResponse) throws IOException {
		Map map	= new HashMap();
		final byte[] bytes = serverResponse != null ? serverResponse.getBytes() : null;
		if (bytes == null || map == null) return null;
		
		String key = null;
		int ttype;
		StreamTokenizer tokens
			= new StreamTokenizer(
			    new InputStreamReader(
			      new BASE64DecoderStream(
				new ByteArrayInputStream(bytes, 4, bytes.length - 4)
			 )));
	
		tokens.ordinaryChars('0', '9');	// reset digits
		tokens.wordChars('0', '9');	// digits may start words
		while ((ttype = tokens.nextToken()) != StreamTokenizer.TT_EOF) {
		    switch (ttype) {
		    case StreamTokenizer.TT_WORD:
			if (key == null) {
			    key = tokens.sval;
			    break;
			}
			// fall-thru
		    case '"':
			//if (debugout != null)
			//    debugout.println("DEBUG DIGEST-MD5: Received => "
			//	 	 + key + "='" + tokens.sval + "'");
			if (map.containsKey(key)) {  // concatenate multiple values
				try {
				    Object valObj = (Object)map.get(key);
				    String val = new String(valObj != null ? valObj.toString() + "," + tokens.sval : null);
					map.put(key, val);
				} catch (ClassCastException impossible) {}
			} else {
			    map.put(key, new String(tokens.sval));
			}
			key = null;
			break;
		    }
		}
		return map;
    }

    public String authAPOP(String okLine)
    {
    		if (okLine == null) return null;
    		
	    int challStart = okLine.indexOf('<');	// start of challenge
	    int challEnd = okLine.indexOf('>', challStart); // end of challenge
	    String apopChallenge = null;
	    if (challStart != -1 && challEnd != -1)
	    		try {
	    			apopChallenge = okLine.substring(challStart, challEnd + 1);
	    		} catch (StringIndexOutOfBoundsException ignore) {}
	    return apopChallenge;
	}

    /**
     * Gets the APOP message digest. 
     * From RFC 1939:
     *
     * The 'digest' parameter is calculated by applying the MD5
     * algorithm [RFC1321] to a string consisting of the timestamp
     * (including angle-brackets) followed by a shared secret.
     * The 'digest' parameter itself is a 16-octet value which is
     * sent in hexadecimal format, using lower-case ASCII characters.
     *
     * @param	password	The APOP password
     * @return		The APOP digest or an empty string if an error occurs.
     */
    public String getAPOPDigest(String password, String apopChallenge) {
		String key = apopChallenge + password;
		final MD5Closure md5clo= new MD5Closure(md5,key);
		final Principal p = null; //Owner;
		byte[] digest = null;
		try {
			digest = (byte[])PrincipalUtil.authorize(p, null,md5clo).invoke();
		} catch (NullPointerException e) {}//if (debugout != null && p != null) debugout.println("Authorization failed for " + p.name());} //authorization failed
	    //digest = md5.digest(key.getBytes("iso-8859-1"));	// XXX
		return toHex(digest);
    }
    
    private static char[] digits = {
		'0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    /**
     * Convert a byte array to a string of hex digits representing the bytes.
     */
    private static String toHex(byte[] bytes) {
    		try {
			char[] result = new char[bytes.length * 2];
		
			for (int index = 0, i = 0; index < bytes.length; index++) {
			    int temp = bytes[index] & 0xFF;
			    result[i++] = digits[temp >> 4];
			    result[i++] = digits[temp & 0xF];
			}
			return new String(result);
    		} catch (ArrayIndexOutOfBoundsException ex) { return null;
    		} catch (NullPointerException ex) { return null; }
    }
}
