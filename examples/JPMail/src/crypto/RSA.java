package crypto;

import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec; 
import java.security.spec.X509EncodedKeySpec; 
import java.security.InvalidKeyException;
import java.security.KeyFactory; 
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Key; 

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA // authority(DESprin)
{
	/**
	 * returns a newly generated keypair for use in RSA encryption
	 * @return an RSA KeyPair
	 */
    static public KeyPair generateKeyPair() throws NoSuchAlgorithmException
    {
    		KeyPair keyPair = null;
    		try {
    			keyPair = KeyPairGenerator.getInstance("RSA",new org.bouncycastle.jce.provider.BouncyCastleProvider()).generateKeyPair();
    		} catch (NullPointerException ignore) {} // thrown by getInstance()...
    		return keyPair;
    }

    /**
     * reads a public key from an InputStream in X.509 encoding and returns it
     * @param InputStream with public key
     * @return X.509 public key read in from @in
     */
	public static PublicKey getPublicKey(InputStream in)
	{
		// read keys from file
		final ByteArrayOutputStream pubKeyBaos = new ByteArrayOutputStream();
		
		X509EncodedKeySpec pubKeySpec = null;
		int curByte = 0;
		if (pubKeyBaos != null && in != null) {
			try {
				while ( (curByte = in.read()) != -1) {
					pubKeyBaos.write(curByte);
				}
			} catch (IOException e) {
			}
		
			pubKeySpec = new X509EncodedKeySpec(pubKeyBaos.toByteArray());
			try {
				pubKeyBaos.close();
			} catch (IOException e) {
			}
		}
				
		PublicKey pubKey = null;
		try {
			pubKey = KeyFactory.getInstance("RSA",new org.bouncycastle.jce.provider.BouncyCastleProvider()).generatePublic(pubKeySpec);
		} catch (InvalidKeySpecException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (NullPointerException ignore) { // thrown by getInstance(...).
		}
		
		return pubKey;
	}

    /**
     * reads a private key from an InputStream in PKCS8 encoding and returns it
     * @param InputStream with private key
     * @return PKCS8 private key read in from @in
     */
	public static PrivateKey getPrivateKey(InputStream in)
	{
		// read keys from file
		final ByteArrayOutputStream privKeyBaos = new ByteArrayOutputStream();
		
		int curByte = 0;
		
		PKCS8EncodedKeySpec privKeySpec = null;
		if (privKeyBaos != null && in != null) {
			try {
				while ( (curByte = in.read()) != -1) {
					privKeyBaos.write(curByte);
				}
			} catch (IOException e) {
			}
			
			privKeySpec = new PKCS8EncodedKeySpec(privKeyBaos.toByteArray());
			try {
				privKeyBaos.close();
			} catch (IOException e) {
			}
		}
				
		PrivateKey privKey = null;
		try {
			privKey = KeyFactory.getInstance("RSA",new org.bouncycastle.jce.provider.BouncyCastleProvider()).generatePrivate(privKeySpec);
		} catch (InvalidKeySpecException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (NullPointerException ignore) {} // thrown if getInstance() returns null
		
		return privKey;
	}

    /** 
     * encrypts a String using a previously generated DES Key
     * @param key a previously generated DES Key (e.g. made with DES.getNewKey()
     * @param s the String to encrypt
     * @return a new Ciphertext object which contains both the key and the needed IV
     */
    static public Ciphertext encrypt(Key key, String s)
    //         throws (InvalidKeyException, IllegalBlockSizeException, NullPointerException,
    //		 BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException)
//	 where oneway(DESprin,P)
    {
		Ciphertext ciphertext = null;
	
		try {
		    final Cipher rsaCipher_ = Cipher.getInstance("RSA/ECB/PKCS1Padding",new org.bouncycastle.jce.provider.BouncyCastleProvider());
		    if (rsaCipher_ != null) { 
		    		rsaCipher_.init(Cipher.ENCRYPT_MODE,key);
		    
			    final byte[] input = s.getBytes();
			    final byte[] encrypted = rsaCipher_.doFinal(input);
		    
			    ciphertext = new Ciphertext(encrypted);
		    }
		}
		catch (Exception e) {}

		return ciphertext;
    }

    /** 
     * encrypts a String using a previously generated DES Key
     * @param key a previously generated DES Key (e.g. made with DES.getNewKey()
     * @param s the String to encrypt
     * @return a new Ciphertext object which contains both the key and the needed IV
     */
    static public Ciphertext encrypt(Key key, byte[] input)
    //         throws (InvalidKeyException, IllegalBlockSizeException, NullPointerException,
    //		 BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException)
//	 where oneway(DESprin,P)
    {
		Ciphertext ciphertext = null;
	
		try {
		    final Cipher rsaCipher_ = Cipher.getInstance("RSA/ECB/PKCS1Padding",new org.bouncycastle.jce.provider.BouncyCastleProvider());
		    if (rsaCipher_ != null) { 
		    		rsaCipher_.init(Cipher.ENCRYPT_MODE,key);
		    
//			    final byte[] input = s.getBytes();
			    final byte[] encrypted = rsaCipher_.doFinal(input);
		    
			    ciphertext = new Ciphertext(encrypted);
		    }
		}
		catch (Exception e) {}

		return ciphertext;
    }

    /**
     * Decrypts a Ciphertext given a Key, using the RSA algorithm
     * @param key the correct (private) key for the given ciphertext
     * @param ciph must be a Ciphertext (e.g., generated by RSA.encrypt)
     * @return the plaintext corresponding to the ciphertext
     */
    static public String decrypt(Key key, Ciphertext ciph) 
	 throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, 
		 NoSuchPaddingException, InvalidAlgorithmParameterException, 
		 NoSuchAlgorithmException, NullPointerException, IllegalArgumentException
    {
		Cipher rsaCipher_ = Cipher.getInstance("RSA/ECB/PKCS1Padding",new org.bouncycastle.jce.provider.BouncyCastleProvider());
	
		rsaCipher_.init(Cipher.DECRYPT_MODE,key);//.getBytes()));
		    
		//byte[] encrypted = ciph.encText.getBytes();
		String output = new String(rsaCipher_.doFinal(ciph.encText));
	
		return output;
    }
    
/*    static public void main(String[] args) 
    {
		boolean getPwdFromUser = false;
		Runtime runtime = null;
	
		try {
		    runtime = Runtime.getRuntime();
		} catch (SecurityException e) {}
		
		final PrincipalStore{} mph = PrincipalStorePolicy.setupPolicy(user);
	
		//	if (user actsfor mgr)
		//	    if (outS != null) outS.println("Mgr <= User");
	
		Principal bonoP = (mph != null) ? bonoP = mph.getPrincipal("bono") : null;
	
		final principal{} bono = bonoP;
	

	 	if (user actsfor bono) {
			BufferedReader inS = null; 
			PrintStream outS = null;
		 	try{
		 	    outS = runtime.stdout();
		 	}
		 	catch (SecurityException ex) { should do something here}
			catch (NullPointerException e) {}

	 		try {
	 			inS = declassify(new BufferedReader(new InputStreamReader(runtime.stdin())));
	 		}
	 		catch (SecurityException ex) {}//if (outS != null) outS.println("Security exception thrown when opening input stream!");}
	 		catch (NullPointerException e) {}

	 		KeyPair keyPair = null;
	 		try {
	 			keyPair = RSA.generateKeyPair();
	 		} catch (NoSuchAlgorithmException ignore) {}
	 		
	 		// create keys and save them to files
	 		if (outS != null) outS.println("Creating keys and writing to files.");
	 		
	 		String principalName = bonoP == null ? "default" : bonoP.name();
	 		String pubKeyFile = principalName + ".pubkey";
	 		String privKeyFile = principalName + ".privkey";
		
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
	 		
	 		//////// Encryption/Decryption ////////
	 		if (outS != null) outS.println("Beginning encryption phase...");
	 		FileInputStream pubKeyIn = null;
	 		FileInputStream privKeyIn = null;
	 		
	 		try {
				pubKeyIn = runtime.openFileRead(pubKeyFile);
				privKeyIn = runtime.openFileRead(privKeyFile);
			} catch (IOException ignore) {
			} catch (SecurityException ignore) {
			} catch (NullPointerException ignore) {}
	 		
	 		PublicKey{} pubKey = declassify(RSA.getPublicKey(pubKeyIn),{});
	 		PrivateKey privKey = declassify(RSA.getPrivateKey(privKeyIn),);
	 		 
	 		String text = "Hello world!  This is my RSA program!!";
	 		if (outS != null) outS.println("The original text: " + text);
	 		byte[] plaintext = text.getBytes();
			RSAClosure[bono,{}]{} rsaClo = new RSAClosure[bono,{}](pubKey,plaintext);
			Ciphertext{} tmp = null;
			try {
				tmp = (Ciphertext)PrincipalUtil.authorize(bono,"bonoPassword",rsaClo).invoke();
			} catch (ClassCastException ex) {
			} catch (NullPointerException ex) {}
			final Ciphertext{} ciphertext = tmp;
			if (outS != null) try {outS.println("The ciphertext: " + new String(ciphertext.encText));
							 } catch (NullPointerException ignore) {}

			try {
				final String decryptedText = RSA.decrypt(privKey,ciphertext); 
		 		if (outS != null && decryptedText != null) outS.println("Decrypted text is: " + decryptedText);
			} catch (Exception ignore) {}
	 	}
	 }
*/}