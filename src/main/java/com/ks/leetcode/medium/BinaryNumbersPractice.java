package com.ks.leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryNumbersPractice {

	public static void generateBinaryNumbers(int n) {
		
		int x=Math.Math.pow(2, n);
		System.out.println("x="+x);
		int [][] result=new int[][n];
		for(int i=0;i<=x;i++) {
		for(int j=0;j<=n;j++) {
			for(int k=0;k<=1;k++) {				
				
				result[i][j]=
				result.add(String.valueOf(i)+String.valueOf(j)+String.valueOf(k));
			}
		}	
		}
		
		
		
//		for(int i=0;i<=1;i++) {
//			for(int j=0;j<=1;j++)
//			for(int k=0;k<=1;k++) {				
//				System.out.println(result[i]);
//			}
//		}
//		}
		
		
		System.out.println(result);
	}
	public static void main(String[] args) {
	generateBinaryNumbers(4);

	}

}
