package com.ks.leetcode.medium;

import java.util.Arrays;

public final class AmazonCellsProb {

	public static int[] findStatus(int[] listOrig, int numberOfDays) {
		
		int [] list = Arrays.copyOf(listOrig, listOrig.length);		
		int result[]=new int[list.length];
		
		for(int i=0; i<numberOfDays;i++) {
			for(int j=0;j<list.length;j++) {
				
				int prev= j==0?0:list[j-1];
				int next= j==list.length-1?0:list[j+1];
				result[j]=calcStatus(prev,next);			
			}
			
			list= Arrays.copyOf(result,list.length);
			
		}
		return result;
	}
	
	
	private static int calcStatus(int prev,int next) {
		
		if(prev == next) return 0;
		else return 1;
	}
	public static void main(String[] args) {

		int [] houses = {1,1,1,0,1,1,1,1};
		
		int numberOfDays=2;
		
		int[] status=findStatus(houses,numberOfDays);
	
	System.out.println(Arrays.toString(status));
	
	}

}
