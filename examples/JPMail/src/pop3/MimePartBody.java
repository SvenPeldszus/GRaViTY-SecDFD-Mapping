/**
 * 
 */
package pop3;

import java.io.BufferedReader;

/**
 * @author phicks
 *
 */

public abstract class MimePartBody {
	final boolean isLast;

	public MimePartBody(boolean isLast)
	{
		this.isLast = isLast;
	}
	
	public String toString()
	{
		return "NOT INSTANTIATED.\n";
	}
	
 	/**
 	 * When part ends with "--" + boundary + "--" it is the last one.  Need to notify the caller of this
 	 * this method should return true in that case
 	 */
    public boolean isLast() {
    		return isLast;
    	}
}
