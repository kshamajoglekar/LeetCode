package com.ks.leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GCD {
	
	public static int findGCD(int[] list,int n) {
		
		int min=Arrays.stream(list).min().getAsInt();
		
		int gcd=1;
		boolean aDivisor;
		
		// the time complexity of the solution is dependent of its contents. 
		//higher numbers in the list results in higher time complexity
		
		
		for(int i=2;i<min;i++) {
			aDivisor=true;
			for(int j :list) {
			if(j%i!=0) {
				aDivisor=false;
				break;	
				}
			};
			if(aDivisor) gcd=i;
		}
		return gcd;

	}
	
	public static void main(String[] args) {
		
		int[] list= {4000,1000};
		int GCD=findGCD(list, list.length);
		System.out.println("gcd="+GCD);
	}

}
