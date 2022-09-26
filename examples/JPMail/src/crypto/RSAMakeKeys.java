package crypto;

import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Key; 
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

// for testing purposes
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class RSAMakeKeys
{
    static public void main(String[] args) 
    {
    	jif.runtime.Runtime runtime = null;
	
		try {
		    runtime = jif.runtime.Runtime.getRuntime();
		} catch (SecurityException e) {}
		
		BufferedReader inS = null; 
		PrintStream outS = null;
	 	try{
	 	    outS = runtime.stdout();
	 	}
	 	catch (SecurityException ex) {/* should do something here*/}
		catch (NullPointerException e) {}

 		try {
 			inS = new BufferedReader(new InputStreamReader(runtime.stdin()));
 		}
 		catch (SecurityException ex) {}//if (outS != null) outS.println("Security exception thrown when opening input stream!");}
 		catch (NullPointerException e) {}

 		KeyPair keyPair = null;
 		try {
 			keyPair = RSA.generateKeyPair();
 		} catch (NoSuchAlgorithmException ignore) {}
 		
 		// create keys and save them to files
 		if (outS != null) outS.println("Creating keys and writing to files.");
 		
 		String principalName = "failed";
 		try {
 			principalName = args != null ? args[0] : "default";
 		} catch (ArrayIndexOutOfBoundsException impossible) {}
 		
 		String pubKeyFile = "keys/" + principalName + ".pubkey";
 		String privKeyFile = "keys/" + principalName + ".privkey";
	
		// write out public key
		FileOutputStream out = null;
		try {
			out = runtime.openFileWrite(pubKeyFile,false);
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}

		try {
			out.write(keyPair.getPublic().getEncoded());
			out.close();
		} catch (IOException e) {
		} catch(NullPointerException ignore) {} // thrown if out == null

		// write out private key
		try {
			out = runtime.openFileWrite(privKeyFile,false);
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}

		try {
			out.write(keyPair.getPrivate().getEncoded());
			out.close();
		} catch (IOException e) {
		} catch (NullPointerException ignore) {} // thrown if out == null or keyPair == null
	 }
}