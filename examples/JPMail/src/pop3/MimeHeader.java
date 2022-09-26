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
public class MimeHeader {
	/* == Data Fields ================================================ */
	protected final String toAddress;
	protected final String fromAddress;
	protected final String sendDate;
	protected final String subject;
	protected final ContentType contentType;
	protected final String mimeVersion;
	protected final String mailLblStr;
	protected final String crypto;

	/* == Constructors =============================================== */
	/**
	 * Use this constructor for creating new incoming messages which could then be
	 * filled in with getField(), etc.
	 */
	public MimeHeader(String toAddress, String fromAddress, String sendDate, String subject, String mailLblStr,
			String crypto, ContentType contentType, String mimeVersion) {
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.sendDate = sendDate;
		this.subject = subject;
		this.mailLblStr = mailLblStr;
		this.crypto = crypto;
		this.mimeVersion = mimeVersion;
		this.contentType = contentType;
	}

	/**
	 * Use this constructor to create new OutGoing messages
	 */
	public MimeHeader(String toAddress, String fromAddress, String sendDate, String subject, String mailLblStr,
			String crypto) {
		this.mimeVersion = "1.0";
		this.contentType = new ContentType("multipart", "mixed", "JPII-Mail-99--9999999999");
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.sendDate = sendDate;
		this.subject = subject;
		this.mailLblStr = mailLblStr;
		this.crypto = crypto;
	}

	public String getToAddress() {
		return toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getSendDate() {
		return this.sendDate;
	}

	public String getSubject() {
		return subject;
	}

	public String getLabelStr() {
		return mailLblStr;
	}

	public String getMimeVersion() {
		return this.mimeVersion;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public String getCrypto() {
		return this.crypto;
	}

	public String getBoundary() {
		if (contentType != null)
			return contentType.getBoundary();
		else
			return null;
	}

	public String getMailLblStr() {
		return mailLblStr;
	}

	/**
	 * This appears at the beginning of each multipart
	 */
	public String getBeginBoundary() {
		return "--" + this.getBoundary();
	}

	/**
	 * This appears at the end of the whole body No more MultiParts after this
	 */
	public String getEndBoundary() {
		return "--" + this.getBoundary() + "--";
	}

	// adds crypto string to an existing MimeHeader and returns the new MimeHeader
	public MimeHeader addCrypto(String crypto) {
		return new MimeHeader(this.toAddress, this.fromAddress, this.sendDate, this.subject, this.mailLblStr, crypto,
				this.contentType, this.mimeVersion);
	}

	public static MimeHeader getMimeHeader(BufferedReader in) {
		if (in == null)
			return null;

		String toAddress = null;
		String fromAddress = null;
		String sendDate = null;
		String subject = null;
		String mailLblStr = null;
		String crypto = null;
		ContentType contentType = null;
		String boundary = null;
		String mimeVersion = null;

		String response = null;
		boolean header = true;
		boolean first = true;
		while (header) {
			try {
				if (first) {
					do {
						response = in.readLine();
					} while (!response.startsWith("Return-Path:"));
					first = false;
				} else
					response = in.readLine();
			} catch (IOException e) {
			} catch (NullPointerException ignore) {
			}

			try {
				if (response == null)
					header = false;
				else if (response.compareTo("") == 0)
					header = false; // end header
				else if (response.compareTo(".") == 0)
					header = false; // end of data??? Not sure if this is needed
				else if (response.startsWith("To: "))
					toAddress = response.substring("To: ".length()); // remove "To: " and store in a variable
				else if (response.startsWith("From: "))
					fromAddress = response.substring("From: ".length()); // remove "From: " and store in field
				else if (response.startsWith("Subject: "))
					subject = response.substring("Subject: ".length());
				else if (response.startsWith("Date: "))
					sendDate = response.substring("Date: ".length());
				else if (response.startsWith("X-Jif-Label: "))
					mailLblStr = response.substring("X-Jif-Label: ".length());
				else if (response.startsWith("X-Crypto:"))
					crypto = response.substring("X-Crypto: ".length());
				else if (response.startsWith("Content-Type: "))
					contentType = ContentType.getContentType(response, in);
				else if (response.startsWith("Mime-Version: "))
					mimeVersion = response.substring("Mime-Version: ".length());
			} catch (NullPointerException ignore) { // response shouldn't be null
			} catch (StringIndexOutOfBoundsException ignore) {
			} // shouldn't happen
		}

		return new MimeHeader(toAddress, fromAddress, sendDate, subject, mailLblStr, crypto, contentType, mimeVersion);
	}

	public String toString() {
		String out = "";
		out += "Mime-Version: " + this.getMimeVersion() + "\n";
		if (this.contentType != null)
			out += this.contentType.toString(); // automatically adds "\n" already
		out += "To: " + this.getToAddress() + "\n";
		out += "From: " + this.getFromAddress() + "\n";
		out += "Date: " + this.getSendDate() + "\n";
		out += "X-Jif-Label: " + this.getMailLblStr() + "\n";
		if (this.crypto != null)
			out += "X-Crypto: " + this.getCrypto() + "\n";
		out += "Subject: " + this.getSubject() + "\n";
		out += "\n"; // end with blank line -- should be CRLF
		return out;
	}

	public static void main(String[] args) {
		jif.runtime.Runtime runtime = null;

		try {
			runtime = jif.runtime.Runtime.getRuntime();
		} catch (SecurityException e) {
		}

		PrintStream outS = null;
		try {
			outS = runtime.stdout();
		} catch (SecurityException ex) {
		} // should do something here
		catch (NullPointerException e) {
		}
		// open a file

		BufferedReader in = null;

		try {
			in = new BufferedReader(new InputStreamReader(runtime.openFileRead("mail.txt")));
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {
		}

// read in key			
		// final label{} lbl = ;

		final MimeHeader mh = MimeHeader.getMimeHeader(in);

		if (outS != null && mh != null) {
			outS.println("mimeVersion: " + mh.getMimeVersion());
			try {
				outS.println("contentType: " + mh.getContentType().getContentType());
				outS.println("subype: " + mh.getContentType().getContentSubtype());
			} catch (NullPointerException ignore) {
			}
			outS.println("boundary: " + mh.getBoundary());
			outS.println("toAddress: " + mh.getToAddress());
			outS.println("fromAddress: " + mh.getFromAddress());
			outS.println("sendDate: " + mh.getSendDate());
			outS.println("subject: " + mh.getSubject());
			outS.println("mailLblStr: " + mh.getMailLblStr());
		}
	}
}
