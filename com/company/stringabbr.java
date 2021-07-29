package com.company;

public class stringabbr {
    public static boolean match(String input, String pattern) {
        // Write your solution here
        boolean result = helper(input, pattern, 0, 0);
        return result;
    }
    private static boolean helper(String input, String pattern, int si, int ti) {
        if (si == input.length() && ti == pattern.length()) {
            return true;
        }
        if (si >= input.length() || ti >= pattern.length()) {
            return false;
        }
        if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
            if (input.charAt(si) == pattern.charAt(ti)) {
                helper(input, pattern, si + 1, ti + 1);
            }
            return false;
        }
        int count = 0;
        while (ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
            count = count * 10 + (pattern.charAt(ti) - '0');
            ti++;
        }
        return helper(input, pattern, si + count, ti);
    }
    public static void main(String[] args) {
        // write your code here
        String s1 = "apple";
        String s2 = "a3e";
        //String
        System.out.println(match(s1, s2));
    }
}
