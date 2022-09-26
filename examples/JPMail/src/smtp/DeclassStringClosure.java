package smtp;

import jif.lang.Closure;

public class DeclassStringClosure implements Closure { 
    final String str; 

    public DeclassStringClosure(String str) {
    		this.str = str;
    }

    // This returns a Ciphertext
    public Object invoke()  {
    		return this.str;
    }
}
