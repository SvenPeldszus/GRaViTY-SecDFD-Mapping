package crypto;

import java.security.Key;

import jif.lang.Closure;

//DeclassPrincipalClosure = new DeclassPrincipalClosure(prin);
//  this declassifies prin to {*lb} and has side-effects of L (could be <top>? at least 
//  it's presumably lb).  This is convoluted, but because the return type has to be 
//  it's not clear how to fix it with the current limitations on principals.
//  it is presumed that P is a ManagerPrincipal, because he always 
//  authorizes the DeclassPrincipalClosure

// P is the manager of the PrincipalStore.
// this will declassify to the security level of the Closure
// not sure if that's a good solution
public class DESStringClosure implements Closure {
	final byte[] plaintext; // should this be a String?
	// final String plaintext;
	final Key key;

	public DESStringClosure(Key key, String plaintext) {
		if (plaintext == null) {
			this.plaintext = null;
		} else {
			final byte[] temp = plaintext.getBytes();
			if (temp != null) {
				this.plaintext = new byte[temp.length];
				if (plaintext != null)
					for (int i = 0; i < temp.length; i++)
						this.plaintext[i] = temp[i];
			} else {
				this.plaintext = null;
			}
		}

		this.key = key;
		// super();
	}

	// This returns a Ciphertext
	public Object invoke() {
		return DES.encrypt(key, plaintext);
	}
}
