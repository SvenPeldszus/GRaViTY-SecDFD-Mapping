/**
 * NOTES: we may want to use an ArrayList to manage the dynamic storage requirements for us for bodyParts
 * This would require making MimePart extend JifObject
 * This may not be a bad idea, but definitely adds some extra baggage
 */
package pop3;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author phicks
 *
 */

public class MimeMailMessage {

	protected final MimeHeader header;
	protected final MimePart[] bodyParts;
	protected final int numParts;

	// == Constructors ===============================================
	/**
	 * @param header To be used for the header of this message
	 */

	/*
	 * public MimeMailMessage(MimeHeader header, MimePart[] bodyParts) { this.header
	 * = header; this.bodyParts = bodyParts; if (bodyParts == null) this.numParts =
	 * 0; else this.numParts = bodyParts.length; // presume the array is full }
	 */
	/**
	 * @param header To be used for the header of this message
	 */
	public MimeMailMessage(MimeHeader header, MimePart[] bodyParts, int numParts) {
		this.header = header;
		this.bodyParts = bodyParts;
		this.numParts = numParts; // presume the array is full
	}

	/**
	 * Use this for constructing MimeMailMessages when we know the data from the
	 * outset
	 */
	/*
	 * public MimeMailMessage(String toAddress, String fromAddress, String sendDate,
	 * String subject, String mailLblStr, MimePart[] bodyParts) { this.header = new
	 * MimeHeader(toAddress,fromAddress,sendDate,subject,mailLblStr); this.bodyParts
	 * = bodyParts; this.numParts = bodyParts.length; }
	 */
	/**
	 * Use this for constructing MimeMailMessages when we know the data from the
	 * outset
	 */
	/*
	 * public MimeMailMessage(String toAddress, String fromAddress, String sendDate,
	 * String subject, String mailLblStr, MimePart[] bodyParts, int numParts) {
	 * this.header = new
	 * MimeHeader(toAddress,fromAddress,sendDate,subject,mailLblStr); this.bodyParts
	 * = bodyParts; this.numParts = numParts; }
	 */
	// === Accessor methods ============================================
	public MimeHeader getMimeHeader() {
		return this.header;
	}

	public String getFromAddress() {
		return this.header == null ? null : this.header.getFromAddress();
	}

	public String getToAddress() {
		return this.header == null ? null : this.header.getToAddress();
	}

	public String getRcptLblStr() {
		return this.header == null ? null : this.header.getLabelStr();
	}

	public MimePart[] getMimeParts() {
		return this.bodyParts;
	}

	public int getNumParts() {
		return this.numParts;
	}

	public String toString() {
		String out = "";
		if (this.header != null)
			out += this.header.toString();
		if (this.bodyParts != null) {
			try {
				for (int i = 0; i < this.bodyParts.length; i++)
					out += this.bodyParts[i].toString();
			} catch (NullPointerException ignore) { // only thrown if mp[i] == null
			} catch (ArrayIndexOutOfBoundsException impossible) {
			} // we check
		}
		return out;
	}

	/**
	 * This routine adds a MimePart to the end of the array of MimePart's,
	 * allocating more space if necessary
	 * 
	 * @param newPart A new MimePart to add to the list of parts in the Body of this
	 *                message
	 */
	/*
	 * public void addMimePart(MimePart newPart) { try { if (this.numParts ==
	 * bodyParts.length) { // if we need more space // back up current Mimeparts
	 * MimePart[] parts = new MimePart[bodyParts.length + 5]; // allocate space for
	 * 5 more for (int i = 0; i < bodyParts.length; i++) parts[i] = bodyParts[i];
	 * 
	 * // reallocate bodyParts to be bigger bodyParts = new MimePart[parts.length];
	 * 
	 * // copy back into bodyParts for (int i = 0; i < numParts; i++) bodyParts[i] =
	 * parts[i]; }
	 * 
	 * // add new part bodyParts[numParts++] = newPart; } catch
	 * (NullPointerException ignore) { // caused by lack of memory? } catch
	 * (ArrayIndexOutOfBoundsException ignore) {} // shouldn't be possible, since we
	 * do bounds checking }
	 */
	/**
	 * This routine reads in the next part from the input stream provided, storing
	 * that part in this message
	 * 
	 * @param in An input stream, presumably a Socket, from which the next MimePart
	 *           can be read
	 */
	public static MimeMailMessage getMimeMailMessage(BufferedReader in) {
		if (in == null)
			return null;

		MimeHeader header = null;
		MimePart[] bodyParts = new MimePart[10];
		int numParts = 0;

		header = MimeHeader.getMimeHeader(in);

		// read in dead text between header and first MimePart
		String resp = null;
		try {
			do {
				resp = in.readLine();
			} while (!resp.startsWith(header.getBeginBoundary()));
		} catch (NullPointerException ignore) { // thrown by resp.compareTo(...)
		} catch (IOException ignore) {
		}

		MimePart part = null;

		try {
			do {
				part = MimePart.getMimePart(in, header);
				if (numParts >= bodyParts.length) { // ran out of space; reallocate 10 more and copy
					MimePart[] temp = new MimePart[numParts + 10];
					for (int i = 0; i < numParts; i++) // save existing body parts
						temp[i] = bodyParts[i];
					bodyParts = new MimePart[numParts + 10]; // reallocate more space
					for (int i = 0; i < numParts; i++)
						bodyParts[i] = temp[i]; // copy back into bodyParts
				}

				bodyParts[numParts++] = part;
			} while (part != null && !part.isLast());
		} catch (ArrayIndexOutOfBoundsException ignore) { // shouldn't happen, because we check
		} catch (ArrayStoreException ignore) { // apparently caused by assigning temp[i] = bodyParts[i] and vice versa
		}

		// read out the epilogue until the end, indicated by "."
		try {
			do {
				resp = in.readLine();
			} while (resp.compareTo(".") != 0);
		} catch (NullPointerException ignore) { // thrown by resp.compareTo(...)
		} catch (IOException ignore) {
		}

		return new MimeMailMessage(header, bodyParts, numParts);
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
			in = new BufferedReader(new InputStreamReader(runtime.openFileRead("mime-mail-message-test.txt")));
		} catch (IOException ignore) {
		} catch (SecurityException ignore) {
		} catch (NullPointerException ignore) {
		}

// read in key			
		// final label{} lbl = ;

		final MimeMailMessage mmm = MimeMailMessage.getMimeMailMessage(in);

		if (outS != null && mmm != null) {
			final MimeHeader mh = mmm.getMimeHeader();
			final MimePart[] mp = mmm.getMimeParts();

			if (mh != null)
				outS.println(mh.toString());
			if (mp != null) {
				try {
					for (int i = 0; i < mp.length; i++)
						outS.println(mp[i].toString());
				} catch (NullPointerException ignore) { // only thrown if mp[i] == null
				} catch (ArrayIndexOutOfBoundsException impossible) {
				} // we check
			}
		}
	}
}
