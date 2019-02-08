package crypto;

import java.io.FileOutputStream;
import java.io.IOException;

// This class combines the initialization vector with the encrypted String
// If there is no initialization vector (as in RSA), then it contains only the ciphertext
public class Ciphertext
{
    public final byte[] encText;	// the encrypted string
    public final byte[] iv;	// the initialization vector
    public Ciphertext(byte[] encrypted)
    {
    		encText = encrypted;
    		iv = null;
    	}
    	
    public Ciphertext(byte[] encrypted, byte[] initVector)
    {
    		encText = encrypted;
    		iv = initVector;
    }
    
    public void toFile(FileOutputStream encFos) throws IOException
    {
    		this.toFile(encFos,null);
    	}
    	
    public void toFile(FileOutputStream encFos, FileOutputStream ivFos) throws IOException
    {
    		if (encText != null && encFos != null) {
    			try {
		    		for (int i = 0; i < encText.length; i++)
		    			encFos.write(encText[i]);
		    	} catch (ArrayIndexOutOfBoundsException impossible) {}

		    	encFos.close(); // shouldn't add anything else, once it has been written
        }
        
    		if (iv != null && ivFos != null) {
    			try {
	    			for (int i = 0; i < iv.length; i++)
		    			ivFos.write(iv[i]);
		    	} catch (ArrayIndexOutOfBoundsException impossible) {}
		    	
		    	ivFos.close();  // shouldn't add anything to this, once it has been written
    		}
    	}
}