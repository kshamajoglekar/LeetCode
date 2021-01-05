package com.ks.leetcode.hard;

public class SumWithoutAdd {
    public static void main(String[] args) {
        int a = 759;
        int b = 674;

        int result = SumWithoutAdd.add(a, b);

        System.out.println(result);
    }

    private static int add(int a, int b) {

//        if(b== 0) return a;
//
//        int sum= a^b;
//        int carry = (a & b) << 1;
//
//        add(sum, carry);
//
//        return sum;

        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            System.out.println("sum== " + sum);
            System.out.println("cary== " + carry);

            a = sum;
            b = carry;
        }
        return a;
    }
}
