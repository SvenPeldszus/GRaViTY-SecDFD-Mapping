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
public class ContentDisposition {
    /*== Data Fields ================================================*/
    protected final String disposition;
    protected final String filename;

// we could add a parameter list here to keep all possible parameters

    /*== Constructors ===============================================*/
    public ContentDisposition(String disposition, String filename)
    {
    		this.disposition = disposition;
    		this.filename = filename;
    }

    public String getDisposition() {
		return this.disposition;
	}
	
    public String getFilename() {
		return this.filename;
	}

    public boolean isAttachment() {
    		boolean isAttachment = false;
    		try {
    			isAttachment = this.disposition.compareTo("attachment") == 0;
    		} catch (NullPointerException ignore) {} // necessary because compareTo throws this exception based on arg
    		return isAttachment;
    	}
   
	public String toString()
	{
		String out = "";
		out += "Content-Disposition: " + this.getDisposition();
		if (filename != null) out += ";\n" + "    " + "filename=" + this.getFilename();
		
		out += "\n";
		return out;
	}
 	
	/**
	 * pass in line starting with "Content-Disposition: "
	 * continue to read in all parameters
	 * @param contentLine Should begin with "Content-Disposition: " and may contain parameters after a ";"
	 * @param in reader with following lines; this routine will not read in extra format lines
	 * @param lbl The label on the reader and the newly constructed ContentType
	 * @return A newly constructed ContentDisposition with parameters filled in according to @contentLine and @in
	 */
	public static ContentDisposition getContentDisposition(String cLine, BufferedReader in)
	{
		if (in == null || cLine == null) return null;
 		
 		String contentLine = cLine;  // need to copy it so it can be mutable; all params are final
 		String disposition = null;
 		String filename = null;
	
 		try {
 			if (contentLine.startsWith("Content-Disposition: ")) {
		    		if (contentLine.indexOf(";") == -1) {
		    			disposition = contentLine.substring("Content-Disposition: ".length());
		    		} else {
		    			disposition = contentLine.substring("Content-Disposition: ".length(), contentLine.indexOf(";"));

		    			// if there's a ";" at the end (i.e. later than the parameter which has "="), then keep going to the next line
		    			while (contentLine != null && contentLine.lastIndexOf(";") > contentLine.lastIndexOf("=")) {
		    				contentLine = in.readLine(); // get a new line
		    				// read in a parameters from the new line
			    			if (contentLine.indexOf("filename=") > -1) {
			    				int argIndex = contentLine.indexOf("filename=") + "filename=".length();
			    				filename = contentLine.substring(argIndex);
			    			}
		 			}     
		 		}
	 		}
		} catch (NullPointerException ignore) {
		} catch (StringIndexOutOfBoundsException ignore) {
		} catch (IOException ignore) {}
		
		return new ContentDisposition(disposition,filename);
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
			in = new BufferedReader(new InputStreamReader(runtime.openFileRead("content-disposition-test-email.txt")));
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {}

// read in key			
		String contentLine = null;
		if (in != null) {
			try {
				contentLine = in.readLine();  // should start with "Content-Disposition:"
			} catch (IOException ignore) {}
		}

		final ContentDisposition cd = ContentDisposition.getContentDisposition(contentLine,in);
		
		if (outS != null && cd != null) {
			outS.println("disposition: " + cd.getDisposition());
			outS.println("filename: " + cd.getFilename());
			if (cd.isAttachment()) outS.println("It is an attachment.");
			else outS.println("not an attachment.");
		}
	}
}