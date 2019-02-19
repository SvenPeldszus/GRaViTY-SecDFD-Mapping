package org.gravity.mapping.secdfd;

/**
 * This class provides functionalities for finding similiar Strings
 * 
 * @author speldszus
 *
 */
public class StringCompare {

	/**
	 * Compares the two given Strings and checks if they are similar
	 * 
	 * @param first The first String
	 * @param second The second String
	 * @return true, if the Strings are similar
	 */
	public static boolean compare(String first, String second) {
		int length1 = first.length();
		int length2 = second.length();
		
		// The length of the Stings should not be too different
		if(Math.abs(length1 - length2) > Math.max(length1, length2)*0.5) {
			return false;
		}
		
		// Check if the longer String contains the shorter String
		if(length1 > length2) {
			return first.toLowerCase().contains(second.toLowerCase());
		}
		else {
			return second.toLowerCase().contains(first.toLowerCase());
		}
	}
}
