package crypto;

import jif.lang.Closure;

// For this to be useful, I think  and  should be equal.
public class DeclassKeyClosure implements Closure { 
    final byte[] keyBits;

    public DeclassKeyClosure(byte[] keyBits) {
/*    		int len = keyBits == null ? 0 : keyBits.length;
    		this.keyBits = new byte[len];
    		try {
    			for (int i = 0; i < len; i++)
    				this.keyBits[i] = keyBits[i];
    		} catch (ArrayIndexOutOfBoundsException ignore) {
    		} catch (NullPointerException ignore) {}
*/  
    		this.keyBits = keyBits;
    }

    // the principals are owned by the Manager as they are stored in the Store
    // this releases them to the public
    public Object invoke()  {
		int len = this.keyBits == null ? 0 : this.keyBits.length;
		final byte[] keyBits = new byte[len];
		
		try {
			for (int i = 0; i < len; i++) 
				keyBits[i] = this.keyBits[i];
		} catch (ArrayIndexOutOfBoundsException ignore) {
		} catch (NullPointerException ignore) {}
	//		return declassify(keyBits,);
		return keyBits;
    }
}
