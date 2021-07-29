package com.company;

public class LCS {
    public static int[] longest(int[] a) {
        // Write your solution here
        int[] m = new int[a.length];
        m[0] = 1;
        int globalMax = 0;
        for (int i = 1; i < a.length; i++) {
            m[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    m[i] = Math.max(m[i], m[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, m[i]);
        }
        int[] result = new int[globalMax];
        int j = globalMax - 1;
        for (int i = m.length - 1; i >= 0; i--) {
            if (m[i] == globalMax--) {
                result[j--] = a[i];
                if (j == -1) {
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String args[]) {
        int[] a = new int[]{28,4,8,14,14};
        for (int num : longest(a)) {
            System.out.println(num);
        }
    }
}
