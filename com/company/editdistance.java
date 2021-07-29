package com.company;

public class editdistance {
    public static int editDistance(String one, String two) {
        // Write your solution here
        int m = one.length();
        int n = two.length();
        int[][] mem = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    mem[i][j] = j;
                }else if (j == 0) {
                    mem[i][j] = i;
                }else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    mem[i][i] = mem[i - 1][j - 1];
                }else {
                    mem[i][j] = Math.min(mem[i - 1][j] + 1, mem[i][j - 1] + 1);
                    mem[i][j] = Math.min(mem[i][j], mem[i - 1][j - 1] + 1);
                }
            }
        }
        return mem[m][n];
    }
    public static void main(String[] args) {
        // write your code here
        String one = "ab";
        String two = "dbbabc";
        //String
        System.out.println(editDistance(one, two));
    }
}
