package crypto;

import java.security.Key;

import jif.lang.Closure;

// Note: this declassifying encryption is deceptive, because the re-classification
// will happen at the level of the private key which may not be the  here.
// One must be careful with this.  A more appropriate choice is RSASelfClosure (in the jifpol
// distribution)
// which ensures the private key and the data have the same label.
public class RSAClosure implements Closure {
	final byte[] plaintext; // should this be a String?
	final Key key;

	public RSAClosure(Key key, byte[] plaintext) {
		this.plaintext = plaintext;
		this.key = key;
	}

	// This returns a Ciphertext
	public Object invoke()  {
    		return RSA.encrypt(key,plaintext);
    }
}
