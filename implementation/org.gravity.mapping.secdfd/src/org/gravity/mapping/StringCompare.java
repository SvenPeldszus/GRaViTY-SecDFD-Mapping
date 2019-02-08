package org.gravity.mapping;

public class StringCompare {

	public static boolean compare(String first, String second) {
		if(first.length() > second.length()) {
			return first.toLowerCase().contains(second.toLowerCase());
		}
		else {
			return second.toLowerCase().contains(first.toLowerCase());
		}
	}
}
