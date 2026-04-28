package com.ks.leetcode;

import java.util.Arrays;

public class CharFrequency {
    public String frequencySort(String s) {

        char[] chars = s.toCharArray();
        int[] frequency = new int[57];
        int[][] sorted = new int[57][1];

        int size = 0;
        for (char ch : chars) {
            frequency[ch - 'A'] = frequency[ch - 'A'] + 1;
            sorted[size][0] = ch - 'A';
            sorted[size][1] = frequency[ch - 'A'];
            size++;
            int current = size;
            while (current > 0 && (sorted[current][1] < sorted[current - 1][1])) {
                int[] temp = sorted[current];
                sorted[current] = sorted[current - 1];
                sorted[current - 1] = temp;
            }
        }


        for (char ch : chars) {

            frequency[ch - 'A'] = frequency[ch - 'A'] + 1;
            System.out.println("ch - 'A' ==" + (ch - 'A'));
            System.out.println(" frequency[ch - 'A']  ==" + frequency[ch - 'A']);

        }

        for (int i = 0; i < frequency.length; i++) {
            int ch = i + 'A';

            if (frequency[i] > 0) {
                System.out.println((char) ch + "  " + frequency[i]);
            }
        }

        System.out.println("------------------");
        int[] filteredFreq = Arrays.stream(frequency).filter(value -> value > 0).sorted().toArray();

        for (int i = 0; i < filteredFreq.length; i++) {
            int ch = i + 'A';

            //  if (frequency[i] > 0) {
//               System.out.println((char) ch + "  " +frequency[i]);
            System.out.println(filteredFreq[i]);

            // }
        }


        // System.out.println("---c - a --"+ ('c' - 'a'));
//        System.out.println("---c - A ---"+('c' - 'A'));
//        System.out.println("---t - A ---"+('t' - 'A'));
//        System.out.println("---C - A ---"+('C' - 'A'));
//        System.out.println("---T - A ---"+('T' - 'A'));
//        System.out.println("---z - A ---"+('z' - 'A'));
//        System.out.println("---Z - A ---"+('Z' - 'A'));
//

        return null;
    }

    private void swap(int[] ints, int[] ints1) {
        int[] temp = ints;
        ints = ints1;
        ints1 = temp;
    }

    public static void main(String[] args) {
        CharFrequency charFrequency = new CharFrequency();
        charFrequency.frequencySort("CCAA");
    }
}
