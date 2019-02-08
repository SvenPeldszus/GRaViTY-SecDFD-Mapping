/**
 * 
 */
package pop3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintStream;

/**
 * @author phicks
 *
 */

public class MimePart7bit extends MimePartBody {
	final String body;

	public MimePart7bit(boolean isLast, String body) {
		super(isLast);
		this.body = body;
	}

	public String getBody() {
		return this.body;
	}

	/**
	 * should print exactly the String of the body's bytes and the blank line
	 * afterwards
	 */
	public String toString() {
		String out = "";
		out += this.getBody() + "\n";

		out += "\n"; // ends with a blank line; should be CRLF
		return out;
	}

	/**
	 * Stream should be ready to read the first line of the body (i.e., the blank
	 * line has been read in) ends with "" (blank line) followed by --boundary
	 */
	public static MimePart7bit getMimePart7bit(BufferedReader in, String boundary) {
		if (in == null)
			return null;

		String body = "";
		boolean isLast = false;

		String response = null;
		boolean inBody = true;
		while (inBody) {
			try {
				response = in.readLine();
			} catch (IOException e) {
			}

			try {
				if (response == null)
					inBody = false;
				else if (response.startsWith("--" + boundary)) {
					inBody = false; // end body
					if (response.startsWith("--" + boundary + "--"))
						isLast = true; // last body
				} else
					body += response + "\n";
			} catch (NullPointerException ignore) {
			} // response shouldn't be null
		}

		return new MimePart7bit(isLast, body);
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

		final MimePart7bit mt = MimePart7bit.getMimePart7bit(in,"Apple-Mail-31--552966314");
		
		if (outS != null && mt != null) {
			outS.println("body: ");
			outS.println(mt.getBody());
			if (mt.isLast()) outS.println("Last one");
			else outS.println("more bodies to come.");
		}
	}

}
