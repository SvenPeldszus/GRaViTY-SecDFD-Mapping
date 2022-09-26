package crypto;

import java.security.MessageDigest;

import jif.lang.Closure;

public class MD5Closure implements Closure {
	final String plaintext; // should this be a String?
	final MessageDigest md5;

	public MD5Closure(MessageDigest md5, String plaintext) {
		this.plaintext = plaintext;
		this.md5 = md5;
		// super();
	}

	// This returns a Ciphertext
	public Object invoke()  {
    		String plaintxt = plaintext;
    		return md5 != null ? md5.digest( plaintxt != null ? plaintxt.getBytes() : null ) : null;
    }
}
