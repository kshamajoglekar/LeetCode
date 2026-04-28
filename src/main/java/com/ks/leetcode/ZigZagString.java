package com.ks.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigZagString {


    public static void main(String[] args) {
        ZigZagString zz = new ZigZagString();
        String res = zz.convert("PAYPALISHIRING", 5);
        System.out.println("res==" + res);
    }

    public String convert(String s, int numRows) {
        String[] list = new String[numRows];
        char[] chars = s.toCharArray();
        if (s == null || s.equals("")) {
            return "";
        }
        if (numRows <= 1 || s.length() == 1) {
            return s;
        }


        String direction = "zig";
        for (int i = 0, j = 0; i < chars.length; i++) {
            String tmp = (list[j] == null) ? "" : list[j];

            tmp = tmp + chars[i];

            list[j] = tmp;

            if (j == numRows - 1) {
                direction = "zag";
            }
            if (j == 0) {
                direction = "zig";
            }

            j = (direction.equals("zig")) ? j + 1 : j - 1;

        }

        String result = Arrays.stream(list).filter(s1 ->
                s1 != null).collect(Collectors.joining(""));
        return result;
    }
}
