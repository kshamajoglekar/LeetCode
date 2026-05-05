package com.ks.leetcode.medium;

import java.util.Arrays;

class longestSubstringNoRepeat {

	public static int lengthOfLongestSubstring(String s) {

		char[] strChars = s.toCharArray();

		// if 2 strings longest 1st one found will be here
		int longest = 0;
 		for (int i = 0; i < strChars.length; i++) {
			int[] chars = new int[256];
			int newStart = i;
			for (int j = i; j < strChars.length; j++) {

				char c = strChars[j];

				if (chars[c] == 0) {
					chars[c]++;
				} else {
					//String.valueOf(strChars, newStart, j - newStart)
					System.out.println(s.subSequence(newStart, j));
					System.out.println("newStart="+newStart+" j="+j);	
					longest = Integer.max(longest,  s.subSequence(newStart, j).length());					
					newStart = j;
					chars=new int[256];
					chars[c]++;
				}
				

			}
		}
		System.out.println("longest=" + longest);
		return 0;
	}

	public static void main(String[] args) {
		lengthOfLongestSubstring("bbbbbbbb");
		//abcabcbb
		//pwwkew
	}
}