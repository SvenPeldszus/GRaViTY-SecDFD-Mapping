/**
 * 
 */
package pop3;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintStream;

/**
 * @author phicks
 *
 */

public class MimePartBase64 extends MimePartBody {
	final byte[] body;
	
	public MimePartBase64(boolean isLast, byte[] body)
	{
		super(isLast);
		this.body = body;
	}
	
	public byte[] getBody() {
		return this.body;
	}
	
	/** 
	 * should print exactly the String of the body's bytes and the blank line afterwards
	 */
	public String toString() {
		String out = "";
		
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			OutputStream b64os = new BASE64EncoderStream(bos, Integer.MAX_VALUE);
			b64os.write(this.getBody());
			b64os.flush(); 	// complete the encoding
			out += new String(bos.toByteArray()) + "\n";
		} catch (NullPointerException ignore) { // caused by new String(...)
		} catch (IOException ignore) {}
		
		out += "\n";  // should be followed by a blank line--should be CRLF
		return out;
	}
	
	/**
	 * takes an unencoded byte array and encodes it and returns a new MimePartBase64
	 * @param unencodedBytes a byte array of unencoded bytes
	 * @param lbl the label that should be applied to the new MimePart
	 * @param isLast indicates whether this should be the last attachment
	 */
	public static MimePartBase64 makeMimePartBase64(byte[] unencodedBytes, boolean isLast)
	{
		MimePartBase64 mpb64 = null;
		
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			OutputStream b64os = new BASE64EncoderStream(bos, Integer.MAX_VALUE);
			b64os.write(unencodedBytes);
			b64os.flush(); 	// complete the encoding
			mpb64 = new MimePartBase64(isLast,bos.toByteArray());
		} catch (NullPointerException ignore) { // caused by new String(...)
		} catch (IOException ignore) {}
		
		return mpb64;
	}
	
 	/**
 	 * Stream should be ready to read the first line of the body (i.e., the blank line has been read in)
 	 * ends with "" (blank line) followed by --boundary
 	 */
    public static MimePartBase64 getMimePartBase64(BufferedReader in, String boundary)
    {
 		if (in == null) return null;
 		
 		String body = "";
 		boolean isLast = false;

  		String response = null;
	    boolean inBody = true;
	    while (inBody) {
		    try {
		    		response = in.readLine();
		    }
		    catch (IOException e) {}
		    
		    try {
			    if (response == null) inBody = false;
			    else if (response == "") {}// skip -- boundary should be next		
			    else if (response.startsWith("--" + boundary)) {
			    		inBody = false;  // end body
			    		if (response.startsWith("--" + boundary + "--")) isLast = true;  // last body
			    	}
			    else body += response;
		    } catch (NullPointerException ignore)  {} // response shouldn't be null
	    }	
	    
	    // convert string to byte array via b64 encoding
	    final String allBits = body;
//	    if (allBits != null)
//	    		return new MimePartBase64(isLast,BASE64DecoderStream.decode(allBits.getBytes()));
//	    	else return null;
	    	
	    if (allBits != null) {
	    		final ByteArrayInputStream bais = new ByteArrayInputStream(allBits.getBytes());
	    		final BASE64DecoderStream ba64is = new BASE64DecoderStream(bais);
	    		try {
	    			if (ba64is != null) {
		    			final byte[] bodyBytes = new byte[ba64is.available()]; // this actually over-allocates since available() counts CRLF's
		    			int len = 0;
		    			int val;
		    			try {
			    			while ((val = ba64is.read()) != -1) {
			    				bodyBytes[len++] = (byte)val;
			    			}
			    			//ba64is.read(bodyBytes,0,ba64is.available());
			    			final byte[] outputBytes = new byte[len];  // allocate the number of bytes which were actually read in
			    			for (int i = 0; i < len; i++) // copy the "real" values
			    				outputBytes[i] = bodyBytes[i];
			    			return new MimePartBase64(isLast,outputBytes);
			    		} catch (ArrayIndexOutOfBoundsException e) {return null;}
		    		}
	    			else return null;
	    		} catch(IOException ignore) {return null;} // due to ba64is.read(...) and ba64is.available(...)	
	    	}
	    	else return null;
    } 	
    
 	public static void main(String[] args) 
	{
 		jif.runtime.Runtime runtime = null;
	
		try {
		    runtime = jif.runtime.Runtime.getRuntime();
		} catch (SecurityException e) {}
			
		PrintStream outS = null;
	 	try{
	 	    outS = runtime.stdout();
	 	}
	 	catch (SecurityException ex) {} // should do something here
		catch (NullPointerException e) {}
		// open a file
	
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(runtime.openFileRead("mail.txt")));
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}

		final MimePartBase64 mt = MimePartBase64.getMimePartBase64(in,"Apple-Mail-31--552966314");
		
		if (outS != null && mt != null) {
			outS.println("body: ");
			try {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				OutputStream b64os = new BASE64EncoderStream(bos, Integer.MAX_VALUE);
				b64os.write(mt.getBody());
				b64os.flush(); 	// complete the encoding
				outS.println(new String(bos.toByteArray()));
			} catch (NullPointerException ignore) { // caused by new String(...)
			} catch (IOException ignore) {}
			
			if (mt.isLast()) outS.println("Last one");
			else outS.println("more bodies to come.");
		}
	}
    		
}
