package com.company;

public class largestcross {
    public static int largest(int[][] matrix) {
        // Write your solution here
        int row = matrix.length;
        int column = matrix[0].length;
        if (row == 0 || column == 0) {
            return 0;
        }
        int[][] m = new int[row][column];//answer mem set
        int[][] m1 = new int[row][column];//1 on left
        int[][] m2 = new int[row][column];//1 on right
        int[][] m3 = new int[row][column];//1 on up
        int[][] m4 = new int[row][column];//1 on down
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0 || i == 0) {
                    if (j == 0) {
                        m1[i][j] = matrix[i][j];
                    }
                    if (i == 0) {
                        m3[i][j] = matrix[i][j];
                    }
                }else if (matrix[i][j] == 1) {
                    m1[i][j] = m1[i][j - 1] + 1;
                    m3[i][j] = m3[i - 1][j] + 1;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (j == column - 1 || i == row - 1) {
                    if (j == column - 1) {
                        m2[i][j] = matrix[i][j];
                    }
                    if (i == row - 1) {
                        m4[i][j] = matrix[i][j];
                    }
                }else if (matrix[i][j] == 1) {
                    m2[i][j] = m2[i][j + 1] + 1;
                    m4[i][j] = m4[i + 1][j] + 1;
                }
            }
        }
        int globalMax = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                m[i][j] = Math.min(m1[i][j], m2[i][j]);
                m[i][j] = Math.min(m3[i][j], m[i][j]);
                m[i][j] = Math.min(m4[i][j], m[i][j]);
                globalMax = Math.max(globalMax, m[i][j]);
            }
        }
        return globalMax;
    }
    public static void main(String args[]) {
        int[][] m = new int[4][4];
        m[3][1] = 1;
        int result = largest(m);
        System.out.println(result);
    }
}
