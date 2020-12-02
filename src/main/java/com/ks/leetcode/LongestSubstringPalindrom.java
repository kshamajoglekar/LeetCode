package com.ks.leetcode;

class LongestSubstringPalindrom {

    private static boolean isPalidrom(char[] chars) {

        //char[] chars= str.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

        LongestSubstringPalindrom palindrom = new LongestSubstringPalindrom();
        String ans;
        ans = palindrom.longestPalindrome("babad");
        System.out.println(ans);
        ans = palindrom.longestPalindrome("cbbd");
        System.out.println(ans);
        ans = palindrom.longestPalindrome("ac");
        System.out.println(ans);
        ans = palindrom.longestPalindrome("a");
        System.out.println(ans);
        ans = palindrom.longestPalindrome("bb");
        System.out.println(ans);
    }

    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 1) {
            return s;
        }
        String ans = "";
        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                //String str = String.valueOf(chars, i, (j - i)+1);
//                char[] charsTemp = Arrays.copyOfRange(chars, i, j+1);
//                if (isPalidrom(charsTemp) && charsTemp.length > ans.length()) {
//                    ans = String.copyValueOf(charsTemp);
//                }


        }
        return "";
    }

    //return ans; //TODO change this
}




