package crypto;

import java.security.Principal;

import jif.lang.Closure;
import policy.KeyPrincipal;

// this should be the public key, so we could mark it as public
// not sure if that will just complicate things.  It will need to be declassified anyway
public class RSASelfClosure implements Closure { 
    final byte[] plaintext; // should this be a String?
    //final String plaintext;
    final KeyPrincipal keyP;

    public RSASelfClosure(KeyPrincipal keyP, byte[] plaintext) {
    		this.plaintext = plaintext;
    		this.keyP = keyP;
    		//super();
    }

    // This returns a Ciphertext
    public Object invoke()  {
    		Object o = null;
    		if (keyP != null) {
	    		final Principal kp = keyP;
//	    		if (P actsfor kp) 
	    			o = RSA.encrypt(keyP.getPublicKey(),plaintext);
	    	}
    		return o;
    }
}
