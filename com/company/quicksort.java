package com.company;

import java.util.*;

public class quicksort {
    private static Random random = new Random();
    public static int[] quickSort(int[] array) {
        // Write your solution here
        int n = array.length;
        if(array == null || n == 0){
            return array;
        }
        quickSort1(array, 0, n - 1);
        return array;
    }
    public static void quickSort1(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = left + random.nextInt(right - left + 1);//不要忘记 +1
        swap(array, pivot, right);
        int i = left, j = right - 1;
        while(i <= j){
            if(array[i] < array[right]){
                i++;
            }else{
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        //
        quickSort1(array, left, i - 1);
        quickSort1(array, i, right);
    }
    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String args[]) {
        int[] m = new int[]{1,3,5,2,4};
        m = quickSort(m);
        System.out.println(m);
    }
}
