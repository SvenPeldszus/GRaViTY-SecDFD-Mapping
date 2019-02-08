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
public class ContentType {
    /*== Data Fields ================================================*/
    protected final String contentType;
    protected final String contentSubtype;
    protected final String boundary; 
    protected final String name;
    protected final String charset;
    protected final String format;

// we could add a parameter list here to keep all possible parameters

    /*== Constructors ===============================================*/
    // useful for overall mail content type
    public ContentType(String contentType, String contentSubtype, String boundary)
    {
    		this.contentType = contentType;
    		this.contentSubtype = contentSubtype;
    		this.boundary = boundary;
    		this.name = null;
    		this.charset = null;
    		this.format = null;
    }
    
    // useful for individual mime part content type
    public ContentType(String contentType, String contentSubtype,
    						    String name, String charset, String format)
    {
    		this.contentType = contentType;
    		this.contentSubtype = contentSubtype;
    		this.boundary = null;
    		this.name = name;
    		this.charset = charset;
    		this.format = format;
    }

    public ContentType(String contentType, String contentSubtype, String boundary,
    						    String name, String charset, String format)
    {
    		this.contentType = contentType;
    		this.contentSubtype = contentSubtype;
    		this.boundary = boundary;
    		this.name = name;
    		this.charset = charset;
    		this.format = format;
    }

    public String getContentType() {
		return this.contentType;
	}

    public String getContentSubtype() {
		return this.contentSubtype;
	}

    public String getBoundary() {
		return this.boundary;
	}
	
    public String getCharset() {
		return this.charset;
	}
	
    public String getName() {
		return this.name;
	}

    public String getFormat() {
		return this.format;
	}
	
	public String toString()
	{
		String out = "";
		out += "Content-Type: " + this.getContentType() + "/" + this.getContentSubtype();
		if (boundary != null) out += ";\n" + "    " + "boundary=" + this.getBoundary();
		if (charset != null) out += ";\n" + "    " + "charset=" + this.getCharset();
		if (name != null) out += ";\n" + "    " + "name=" + this.getName();
		if (format != null) out += ";\n" + "    " + "format=" + this.getFormat();
		out += "\n";
		return out;
	}
	
	/**
	 * pass in line starting with "Content-Type: "
	 * continue to read in all parameters
	 * @param contentLine Should begin with "Content-Type: " and may contain parameters after a ";"
	 * @param in reader with following lines; this routine will not read in extra format lines
	 * @param lbl The label on the reader and the newly constructed ContentType
	 * @return A newly constructed ContentType with parameters filled in according to @contentLine and @in
	 */
	public static ContentType getContentType(String cLine, BufferedReader in)
	{
		if (in == null || cLine == null) return null;
 		
 		String contentLine = cLine;  // need to copy it so it can be mutable; all params are final
 		String contentType = null;
 		String contentSubtype = null;
 		String boundary = null;
 		String name = null;
 		String charset = null;
 		String format = null;
	
 		try {
 			if (contentLine.startsWith("Content-Type: ")) {
		    		if (contentLine.indexOf(";") == -1) {
		    			contentType = contentLine.substring("Content-Type: ".length(), contentLine.indexOf("/"));
		    			contentSubtype = contentLine.substring(contentLine.indexOf("/") + 1);
		    		} else {
		    			int argIndex = contentLine.indexOf(";");
		    			contentType = contentLine.substring("Content-Type: ".length(), contentLine.indexOf("/"));
		    			contentSubtype = contentLine.substring(contentLine.indexOf("/") + 1, argIndex);							

		    			// boundary param might be on the same line
		    			if (contentLine.indexOf("boundary=") > -1) {
		    				argIndex = contentLine.indexOf("boundary=") + "boundary=".length();
		    				boundary = contentLine.substring(argIndex);
		    			}

		    			// if there's a ";" at the end (i.e. later than the parameter which has "="), then keep going to the next line
		    			while (contentLine != null && contentLine.lastIndexOf(";") > contentLine.lastIndexOf("=")) {
		    				contentLine = in.readLine(); // get a new line
		    				// read in a parameters from the new line
			    			if (contentLine.indexOf("boundary=") > -1) {
			    				argIndex = contentLine.indexOf("boundary=") + "boundary=".length();
			    				boundary = contentLine.substring(argIndex);
			    			}
			    			else if (contentLine.indexOf("name=") > -1) {
			    				argIndex = contentLine.indexOf("name=") + "name=".length();
			    				name = contentLine.substring(argIndex);
			    			}
			    			else if (contentLine.indexOf("charset=") > -1) {
			    				argIndex = contentLine.indexOf("charset=") + "charset=".length();
			    				charset = contentLine.substring(argIndex);
			    			}
			    			else if (contentLine.indexOf("format=") > -1) {
			    				argIndex = contentLine.indexOf("format=") + "format=".length();
			    				format = contentLine.substring(argIndex);
			    			}
		 			}     
		 		}
	 		}
		} catch (NullPointerException ignore) {
		} catch (StringIndexOutOfBoundsException ignore) {
		} catch (IOException ignore) {}
		
		return new ContentType(contentType,contentSubtype,boundary,name,charset,format);
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
	 	catch (SecurityException ex) {/* should do something here*/}
		catch (NullPointerException e) {}
		// open a file
	
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(runtime.openFileRead("mail.txt")));
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}

// read in key			
		String contentLine = null;
		if (in != null) {
			try {
				contentLine = in.readLine();  // should start with "Content-Type:"
			} catch (IOException ignore) {}
		}

		final ContentType ct = ContentType.getContentType(contentLine,in);
		
		if (outS != null && ct != null) {
			outS.println("type: " + ct.getContentType());
			outS.println("subtype: " + ct.getContentSubtype());
			outS.println("boundary: " + ct.getBoundary());
			outS.println("charset: " + ct.getCharset());
			outS.println("name: " + ct.getName());
		}
	}
}
