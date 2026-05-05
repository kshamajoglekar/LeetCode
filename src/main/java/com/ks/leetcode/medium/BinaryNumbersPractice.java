package com.ks.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryNumbersPractice {

	public static void generateBinaryNumbers(int n) {
		int total = 1 << n;
		System.out.println("x=" + total);
		List<String> result = new ArrayList<>(total);
		for (int i = 0; i < total; i++) {
			String bin = Integer.toBinaryString(i);
			if (bin.length() < n) {
				bin = "0".repeat(n - bin.length()) + bin;
			}
			result.add(bin);
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		generateBinaryNumbers(4);
	}
}
