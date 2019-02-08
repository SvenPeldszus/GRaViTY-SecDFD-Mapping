/**
 * Data structure to store the pertinent mail message header info
 */
package pop3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintStream;


/**
 * @author Boniface Hicks
 *
 */
public class MimePartHeader {
    /*== Data Fields ================================================*/
	protected final String contentTransferEncoding;
    protected final ContentType contentType;
    protected final ContentDisposition contentDisposition;
    protected final MimeHeader mimeHeader;
    
    /*== Constructors ===============================================*/
    /**
     * Use this constructor for creating new incoming messages
     * which could then be filled in with getField(), etc.
     */
     public MimePartHeader(String contentTransferEncoding, ContentType contentType,
    		 						ContentDisposition contentDisposition, MimeHeader mimeHeader)
    {
    	 	this.contentTransferEncoding = contentTransferEncoding;
   		this.contentType = contentType;
    		this.contentDisposition = contentDisposition;
    		this.mimeHeader = mimeHeader;  // needed for boundary, mimeVersion, label?, etc.
    }

    public String getContentTransferEncoding() {
		return this.contentTransferEncoding;
	}

    public ContentType getContentType() {
 		return this.contentType;
 	}

    public ContentDisposition getContentDisposition() {
		return contentDisposition;
	}

    public MimeHeader getMimeHeader() {
    		return this.mimeHeader;
    	}
    	
    	public String getBoundary() {
    		if (mimeHeader == null) return null;
    		else return mimeHeader.getBoundary();
    	}
    	
    	/**
    	 * puts out a header, followed by CRLF
    	 */
    	public String toString() {
		String out = "";
		
		out += "Content-Transfer-Encoding: " + this.getContentTransferEncoding() + "\n";
		if (this.contentType != null) out += this.contentType.toString();
		if (this.contentDisposition != null) out += this.contentDisposition.toString();

		out += "\n";  // a blank line to end the header: should be CRLF, I think
    		return out;
    	}
    	
    	/**
    	 * Should start on the first line of the MimePart (i.e. the begin-boundary has already been read in)
    	 */
 	public static MimePartHeader getMimePartHeader(BufferedReader in, MimeHeader mimeHeader)
 	{
 		if (in == null) return null;
 		
 		String contentTransferEncoding = null;
 		ContentType contentType = null;
 		ContentDisposition contentDisposition = null;

  		String response = null;
	    boolean header = true;
	    while (header) {
		    try {
		    		response = in.readLine();
		    }
		    catch (IOException e) {}
		    
		    try {
			    if (response == null) header = false;		
			    else if (response.compareTo("") == 0) header = false;  // end header
			    else if (response.startsWith("Content-Transfer-Encoding: ")) contentTransferEncoding = response.substring("Content-Transfer-Encoding: ".length()); // remove "To: " and store in a variable
			    else if (response.startsWith("Content-Type: ")) contentType = ContentType.getContentType(response,in);
			    else if (response.startsWith("Content-Disposition: ")) contentDisposition = ContentDisposition.getContentDisposition(response,in);
		    } catch (NullPointerException ignore)  { // response shouldn't be null
		    } catch (StringIndexOutOfBoundsException ignore) {} // shouldn't happen
	    }	
	    
	    return new MimePartHeader(contentTransferEncoding,contentType,contentDisposition,mimeHeader);
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
			in = new BufferedReader(new InputStreamReader(runtime.openFileRead("mime-part-header-test-email.txt")));
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}

		final MimePartHeader mh = MimePartHeader.getMimePartHeader(in,null);
		
		if (outS != null && mh != null) {
			outS.println("Content-Transfer-Encoding: " + mh.getContentTransferEncoding());
			try {
				outS.println("contentType: " + mh.getContentType().getContentType());
				outS.println("subype: " + mh.getContentType().getContentSubtype());
				outS.println("charset: " + mh.getContentType().getCharset());
				outS.println("name: " + mh.getContentType().getName());
				outS.println("format: " + mh.getContentType().getFormat());

				outS.println("Content-Disposition: " + mh.getContentDisposition().getDisposition());
				outS.println("filename: " + mh.getContentDisposition().getFilename());
			} catch (NullPointerException ignore) {}
		}
	}
    
 }
