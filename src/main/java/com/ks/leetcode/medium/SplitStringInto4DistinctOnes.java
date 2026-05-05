package com.ks.leetcode.medium;

public class SplitStringInto4DistinctOnes {

	public static boolean splitCheck(String s) {

		int length = s.length();
			
		
		if (length >= 10) return true;

		if(length < 4) return false;
		
		for(int start=0,last=length-1,j=start+1;j<last-2;j++) {
			for(int k=j+1;k<last-1;k++) {
				for(int l=k+1;l<last;l++) {
					String s1=s.substring(start, j);
					String s2=s.substring(j, k);
					String s3=s.substring(k, l);
					String s4=s.substring(l, last);
				if(!s1.equals(s2) && !s1.equals(s3)&&  !s1.equals(s4) && !s2.equals(s3)
						&& !s2.equals(s4) && !s3.equals(s4)) {
					return true;
				}
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {

		System.out.println("hello world");
		String test1="aaabb";
		String test2="geeksfor";
		
		System.out.println(test1+"is " +splitCheck(test1));
		System.out.println(test2+"is " +splitCheck(test2));
	}

}
