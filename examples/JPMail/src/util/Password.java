package util;

import crypto.DES;
import crypto.DESClosure;
import crypto.Ciphertext;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Password
{
	private Password() {}
	
	// right now, we need to know that pwdL = ; not sure if we can generalize this
	public static char[] getPassword(String pwdFilename, Principal pwdP)
	{
		String _returnString = null; // should return the password at level PwdL

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
				outS.println("=========Got runtime from Password=========");
				outS.println("Reading in password from " + pwdFilename);
			}
			
			FileInputStream inPassword = null;
			FileInputStream inIV = null;
			FileInputStream inKey = null;
			
			try { // upgrading takes place here from PwdL to , made possible by dynamic check
				inPassword = runtime.openFileRead(pwdFilename);
				inIV = runtime.openFileRead(pwdFilename + "_iv");
				inKey = runtime.openFileRead(pwdFilename + "_key");								
			} catch (IOException ignore) { if (outS!= null) outS.println("****IOException");
			} catch (SecurityException ignore) { if (outS != null) outS.println("****SecurityException: " + ignore.toString());
			} catch (NullPointerException ignore) { if (outS != null) outS.println("****NullPointerException");}
	
	// read in key			
			byte [] keyBits = null;
			if (inKey != null) {
				try {
					int keylen = inKey.available();
					keyBits = new byte[keylen];
					for (int i = 0; i < keylen; i++)
						keyBits[i] = (byte)inKey.read();
					inKey.close();
				} catch (IOException ignore) {
				} catch (ArrayIndexOutOfBoundsException impossible) {}
			}
			Key myKey1 = new SecretKeySpec(keyBits,"DES");

// read in IV
			byte[] ivBits = null;			
			if (inIV != null) {
				try {
					int ivlen = inIV.available();
					ivBits = new byte[ivlen];
					for (int i = 0; i < ivlen; i++)
						ivBits[i] = (byte)inIV.read();
					inIV.close();
				} catch (IOException ignore) {
				} catch (ArrayIndexOutOfBoundsException impossible) {}
			}

// read in encText
			byte[] pwdBits = null;			
			if (inPassword != null) {
				try {
					int pwdlen = inPassword.available();
					pwdBits = new byte[pwdlen];
					for (int i = 0; i < pwdlen; i++)
						pwdBits[i] = (byte)inPassword.read();
					inPassword.close();
				} catch (IOException ignore) {
				} catch (ArrayIndexOutOfBoundsException impossible) {}
				
			}
	
			// cipher text is public, because it's encrypted.
			final Ciphertext ciphertext = new Ciphertext(pwdBits,ivBits);
			String encOutputString = null;

			try {
				encOutputString = new String(ciphertext.encText);
			}
			catch (NullPointerException ignore) {}
				
			// decryption
		    try {
		    		_returnString = (String)DES.decrypt(myKey1,ciphertext); // decrypts and upgrades security to PwdL
		    	} catch (InvalidKeyException ex) {  //ignore these for now
		    	} catch (IllegalBlockSizeException ex) {
		    	} catch (BadPaddingException ex) {
		    	} catch (NoSuchPaddingException ex) {
		    	} catch (InvalidAlgorithmParameterException ex) { 
		    } catch (NoSuchAlgorithmException ex) {
		    } catch (NullPointerException ex) {}

		
		final String returnString = _returnString;
		return (returnString == null) ? null : returnString.toCharArray();
	}
	   
	// password must be owned by a single principal, for whom we can check whether he allows DES encryption
	public static void setPassword(String pwdFilename, Principal user)
	{
		jif.runtime.Runtime runtime = null;
		
		try {
			runtime = jif.runtime.Runtime.getRuntime();
		} catch (SecurityException e) {} // should do something here
	
 		BufferedReader inS = null; 
 		try {
 			inS = new BufferedReader(new InputStreamReader(runtime.stdin()));
 		}
 		catch (SecurityException ex) {}//if (outS != null) outS.println("Security exception thrown when opening input stream!");}
 		catch (NullPointerException e) {}

		PrintStream outS = null;
	 	try{
	 	    outS = runtime.stdout();
	 	}
	 	catch (SecurityException ex) {} // should do something here
		catch (NullPointerException e) {}

		char[] pw = new char[50]; // allow password of length 50
		int bufCnt = 0;
		if (outS != null) {
			outS.print("Enter password: ");
			if (inS != null) {
				try {
					do { // read a line or 50 characters, whichever comes first.
						pw[bufCnt] = (char)inS.read();
					} while (bufCnt < 50 && pw[bufCnt++] != '\n');
				}
				catch (IOException e) {}  // not sure what would cause this
				catch (ArrayIndexOutOfBoundsException impossible) {} // we check to make sure this won't happen
			}
		}

		byte[] pw2 = new byte[bufCnt-1];  // bufCnt -1 to remove the \n
		
		// copy, coerce
		try {
			for (int i = 0; i < pw2.length; i++)
				pw2[i] = (byte)pw[i];
		} catch (ArrayIndexOutOfBoundsException impossible) {
		} catch (NullPointerException impossible) {}
	
		// encryption
		Key myKey = null;
		try {
			myKey = DES.getNewKey();
		} catch (NoSuchAlgorithmException impossible) {
		} catch (NullPointerException impossible) {}
					
		final Ciphertext ciphertext = DES.encrypt(myKey,pw2);

		FileOutputStream outPassword = null;
		FileOutputStream outIV = null;
		FileOutputStream outKey = null;
		
		try {
			outPassword = runtime.openFileWrite(pwdFilename, false);
			outIV = runtime.openFileWrite(pwdFilename + "_iv", false);
			outKey = runtime.openFileWrite(pwdFilename + "_key", false);
			
			ciphertext.toFile(outPassword,outIV);
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}
		
		byte[] outKeyBits = null;
		if (myKey != null) outKeyBits = myKey.getEncoded();
		
		if (outKeyBits != null && outKey != null)
    			try {
		    		for (int i = 0; i < outKeyBits.length; i++)
		    			outKey.write(outKeyBits[i]);
		    		outKey.close();    	
		    	} catch (ArrayIndexOutOfBoundsException impossible) {
		    	} catch (IOException ignore) {}
    }
    
    public static byte[] toString64(byte[] bits)
    {
    		byte[] ret = null;
    		try {
	    		ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    		OutputStream b64os = new BASE64EncoderStream(bos, Integer.MAX_VALUE);
    			b64os.write(bits);
    			b64os.flush(); 	// complete the encoding
			ret = bos.toByteArray();
		} catch (IOException ignore) {
		} catch (NullPointerException ignore) {}
		 
    		return ret;
    	}
    		
}
	