package com.ks.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


    String getBinaryNumber(int number) {
        int copy = number;

        if (number < 0) return "-1";
        if (number == 0) return "0";
        if (number == 1) return "1";

        Stack<Integer> resultStack = new Stack<>();
        StringBuilder binary = new StringBuilder();
        while (number != 0) {
            int lastBit = number & 1;
            resultStack.push(lastBit);
            number = number >> 1;
        }

        while (!resultStack.empty()) {
            binary.append(resultStack.pop());
        }

        System.out.println("number=" + copy + "   Binary =" + binary);

        return binary.toString();

    }

    public static void main(String[] args) {
        //generateBinaryNumbers(4);
        BinaryNumbersPractice binary = new BinaryNumbersPractice();
        binary.getBinaryNumber(-1);
        binary.getBinaryNumber(1);
        binary.getBinaryNumber(2);
        binary.getBinaryNumber(3);
        binary.getBinaryNumber(4);
        binary.getBinaryNumber(5);
        binary.getBinaryNumber(8);

    }

}
