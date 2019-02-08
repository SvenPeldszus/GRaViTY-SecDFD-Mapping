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
public class DESClosure implements Closure {
	final byte[] plaintext; // should this be a String?
	// final String plaintext;
	final Key key;

	public DESClosure(Key key, byte[] plaintext) {
		this.plaintext = plaintext;
		this.key = key;
		// super();
	}

	// This returns a Ciphertext
	public Object invoke() {
		return DES.encrypt(key, plaintext);
	}
}
