package crypto;

import java.security.Key;

import jif.lang.Closure;

public class AESClosure implements Closure {
	final byte[] plaintext; // should this be a String?
	// final String plaintext;
	final Key key;

	public AESClosure(Key key, byte[] plaintext) {
		this.plaintext = plaintext;
		this.key = key;
		// super();
	}

	// This returns a Ciphertext
	public Object invoke() {
		return AES.encrypt(key, plaintext);
	}
}
