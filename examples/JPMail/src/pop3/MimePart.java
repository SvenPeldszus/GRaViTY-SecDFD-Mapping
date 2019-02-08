/**
 * 
 */
package pop3;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;

/**
 * @author phicks
 *
 */

public class MimePart {
	final protected MimePartHeader header;
	final protected MimePartBody body;

	public MimePart(MimePartHeader header, MimePartBody body)
	{
		this.header = header;
		this.body = body;
	}

	public MimePartHeader getMimePartHeader()
	{
		return this.header;
	}
	
	public MimePartBody getMimePartBody()
	{
		return this.body;
	}
	
	public boolean isLast()
	{
		if (this.body == null) return true;
		else return this.body.isLast();
	}
	
	public String toString()
	{
		String out = "";
		
		final MimePartHeader mh = this.getMimePartHeader();
		
		if (mh != null) {
			out += "--" + mh.getBoundary() + "\n";  	// starting line
			out += mh.toString();						// rest of the header (including separator space)
			final MimePartBody mp = this.getMimePartBody();
			if (mp != null) out += mp.toString();		// now the body
			if (isLast()) out += "--" + mh.getBoundary() + "--" + "\n";  // ending demarcation 
		}
		return out;
	}
	
	public static MimePart makeBase64Attachment(String name, byte[] data, boolean isLast, MimeHeader mimeHeader)
	{
		if (data == null) return null;
		
		// need to upgrade data so that all the bytes are actually at level , not just bound above by it
		int len = data.length;
		byte[] temp = new byte[len];
		
		try {
			for (int i = 0; i < temp.length; i++)
				temp[i] = data[i];
		} catch (ArrayIndexOutOfBoundsException ignore) { 
			return null;
		} catch (NullPointerException ignore) {
			return null;
		}

		final MimePartHeader mph = new MimePartHeader("base64",
														 new ContentType("text","plain","\"" + name + "\"",null,null),
														 new ContentDisposition("attachment",name),
														 mimeHeader);
		final MimePartBody mpb64 = new MimePartBase64(isLast,temp);
	    	return new MimePart(mph,mpb64);
	}

	public static MimePart make7bitPart(String body, boolean isLast, MimeHeader mimeHeader)
	{
		if (body == null) return null;
		
		final MimePartHeader mph = new MimePartHeader("7bit",
														 new ContentType("text","plain",null,"US-ASCII","flowed"),
														 null,
														 mimeHeader);
		final MimePartBody mpb = new MimePart7bit(isLast,body);
	    	return new MimePart(mph,mpb);
	}
	
    	/**
    	 * Should start on the first line of the MimePart (i.e. the begin-boundary has already been read in)
    	 * reads through the next boundary
    	 */
 	public static MimePart getMimePart(BufferedReader in, MimeHeader mimeHeader)
 	{
 		if (in == null) return null;
 		
 		final MimePartHeader header = MimePartHeader.getMimePartHeader(in,mimeHeader);
 		MimePartBody body = null;
 		
 		if (header != null) {
 			final String encoding = header.getContentTransferEncoding();
 			if (encoding != null)
 				try {
		 			if (encoding.compareTo("base64") == 0)	body = MimePartBase64.getMimePartBase64(in,header.getBoundary());
		 			else if (encoding.compareTo("7bit") == 0) body = MimePart7bit.getMimePart7bit(in,header.getBoundary());
		 		} catch (NullPointerException impossible) {} // because of .compareTo(...)
 		}

	    return new MimePart(header,body);
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
			in = new BufferedReader(new InputStreamReader(runtime.openFileRead("cryptomail.txt")));
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}

		final MimeHeader mimeHeader = MimeHeader.getMimeHeader(in);
		if (outS != null && mimeHeader != null) outS.println("boundary: " + mimeHeader.getBeginBoundary());
		// read in dead text between header and first MimePart
		String resp = null;
		try {
			do {
				resp = in.readLine();
			} while (!resp.startsWith(mimeHeader.getBeginBoundary()));
		} catch (NullPointerException ignore) { // thrown by resp.compareTo(...)
		} catch (IOException ignore) {}
		
		if (outS != null) outS.println("reading in MimePart: ");
		final MimePart mp = MimePart.getMimePart(in,mimeHeader);
		
		if (outS != null && mp != null) {
			final MimePartHeader mh = mp.getMimePartHeader();
			if (mh != null) {
				outS.println("Content-Transfer-Encoding: " + mh.getContentTransferEncoding());
				try {
					outS.println("contentType: " + mh.getContentType().getContentType());
					outS.println("subype: " + mh.getContentType().getContentSubtype());
					outS.println("charset: " + mh.getContentType().getCharset());
					outS.println("name: " + mh.getContentType().getName());
					outS.println("format: " + mh.getContentType().getFormat());
	
					if (mh.getContentDisposition() != null) {
						outS.println("Content-Disposition: " + mh.getContentDisposition().getDisposition());
						outS.println("filename: " + mh.getContentDisposition().getFilename());
					}
					if (mh.getContentTransferEncoding().compareTo("base64") == 0) {
						MimePartBase64 mt = (MimePartBase64)mp.getMimePartBody();
						if (mt != null) {
							outS.println("BASE64 body: ");
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
					else if (mh.getContentTransferEncoding().compareTo("7bit") == 0) {
						MimePart7bit mt = (MimePart7bit)mp.getMimePartBody();
						if (mt != null) {
							outS.println("7bit body: ");
							outS.println(mt.getBody());
							if (mt.isLast()) outS.println("Last one");
							else outS.println("more bodies to come.");
						}
						else outS.println("body is null");
					}
					else outS.println("ERROR: bad encoding type: " + mh.getContentTransferEncoding());
				} catch (NullPointerException ignore) {
				} catch (ClassCastException ignore) {}
			}
		}
	}
}
