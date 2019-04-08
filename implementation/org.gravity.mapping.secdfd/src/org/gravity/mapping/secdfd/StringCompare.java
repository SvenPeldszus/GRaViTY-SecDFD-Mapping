package org.gravity.mapping.secdfd;

import java.util.LinkedList;
import java.util.List;
import org.apache.commons.text.similarity.LevenshteinDistance;
import info.debatty.java.stringsimilarity.Cosine;

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
	public static Integer compareCosine(String first, String second) {
		List<String> words1 = getWords(first);
		List<String> words2 = getWords(second);
		Cosine cosine_class = new Cosine();

		int similar = 0;
		for(String s1 : words1) {
			for(String s2 : words2) {
				
				//if 0, the strings are completely different, if 1, they are the same
				double cos_dist =  cosine_class.similarity(s1, s2);
				int avg = (s1.length() +  s2.length()) / 2;
				double accept = 0; 
				if(avg > 7) {
					accept = 0.7;
				}
				else if(avg > 2) {
					accept = 0.9;
				}
				if(cos_dist >= accept) {
					similar++;
				}
			}
		}
		
		int expect = (int) Math.ceil(((double) Math.max(words1.size(), words2.size())) / 2);
		if (similar < (expect > 0 ? expect : 1)) {
			return -1;
		}
		else {
			double s = ((double) similar)/Math.max(words1.size(), words2.size());
			return (int) (s*100);
		}
	}

	
	/**
	 * Compares the two given Strings and checks if they are similar
	 * 
	 * @param first  The first String
	 * @param second The second String
	 * @return true, if the Strings are similar
	 */	
	public static Integer compare(String first, String second) {
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
		
		if (similar < (expect > 0 ? expect : 1)) {
			return -1;
		}
		else {
			double s = ((double) similar)/Math.max(words1.size(), words2.size());
			return (int) (s*100);
		}
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
