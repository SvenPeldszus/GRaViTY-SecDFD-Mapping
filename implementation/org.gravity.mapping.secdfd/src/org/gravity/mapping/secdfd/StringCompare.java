package org.gravity.mapping.secdfd;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.text.similarity.LevenshteinDistance;

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
	 * @param first  The first String
	 * @param second The second String
	 * @return true, if the Strings are similar
	 */
	
	public static boolean compare_cosine(String first, String second) {
		//TODO
		return true;
	}
	
	//public static int 
	
	public static Integer compare(String first, String second) {
		

		// The length of the Stings should not be too different
//		if(Math.abs(length1 - length2) > Math.max(length1, length2)*0.5) {
//			return false;
//		}

		List<String> words1 = getWords(first);
		List<String> words2 = getWords(second);

		int similar = 0;
		LevenshteinDistance defaultInstance = LevenshteinDistance.getDefaultInstance();
		for(String s1 : words1) {
			for(String s2 : words2) {
				int avg = (s1.length() +  s2.length()) / 2;
				int accept = 0;
				if(avg > 7) {
					accept = 2;
				}
				else if(avg > 2) {
					accept = 1;
				}
				if(defaultInstance.apply(s1, s2) <= accept) {
					similar++;
				}
			}
		}
		
		int expect = (int) Math.ceil(((double) Math.max(words1.size(), words2.size())) / 2);
		
		//alternatively we can calculate the cosine similarity.
		if (similar < (expect > 0 ? expect : 1)) return -1;
		else return similar;
//		return similar >= (expect > 0 ? expect : 1);

		// Check if the longer String contains the shorter String
//		if(length1 > length2) {
//			return first.toLowerCase().contains(second.toLowerCase());
//		}
//		else {
//			return second.toLowerCase().contains(first.toLowerCase());
//		}
	}

	/**
	 * @param string
	 */
	private static List<String> getWords(String string) {
		int start = 0;
		int end = 0;
		List<String> words = new LinkedList<>();
		for (byte c : string.getBytes()) {
			if (end > 0) {
				if (end - start > 1 && Character.isUpperCase(c)) {
					words.add(string.substring(start, end).toLowerCase());
					start = end;
				} else if ('-' == c || '_' == c) {
					words.add(string.substring(start, end).toLowerCase());
					start = end + 1;
				}
			}
			end++;
		}
		words.add(string.substring(start, end).toLowerCase());
		return words;
	}
}
