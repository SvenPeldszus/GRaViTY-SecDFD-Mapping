package crypto;

import java.security.Key;

import jif.lang.Closure;

public class TripleDESClosure implements Closure { 
    final byte[] plaintext; // should this be a String?
    //final String plaintext;
    final Key key;

    public TripleDESClosure(Key key, byte[] plaintext) {
    		this.plaintext = plaintext;
    		this.key = key;
    		//super();
    }

    // This returns a Ciphertext
    public Object invoke()  {
    		return TripleDES.encrypt(key,plaintext);
    }
}
