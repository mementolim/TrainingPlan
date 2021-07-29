package com.company;

public class getCountArray {
    public static int[] countArray(int[] array) {
        // Write your solution here
        int[] index = getIndex(array);
        int[] count = new int[array.length];
        int[] helper = new int[array.length];
        mergeSort(index, count, helper, array, 0, array.length - 1);
        return count;
    }
    private static void mergeSort(int[] index, int[] count, int[] helper, int[] array,
                           int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(index, count, helper, array, left, mid);
        mergeSort(index, count, helper, array, mid + 1, right);
        merge(index, count, helper, array, left, mid, right);
    }
    private static int[] getIndex(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = i;
        }
        return result;
    }
    private static void merge(int[] index, int[] count, int[] helper, int[] array,
                       int left, int mid, int right) {
        copy(index, helper, left, right);
        int l = left;
        int r = mid + 1;
        int cur = left;
        while (l <= mid) {
            if (r > right || array[helper[l]] <= array[helper[r]]) {
                count[helper[l]] += r - mid - 1;
                index[cur++] = helper[l++];
            }else {
                index[cur++] = helper[r++];
            }
        }
    }
    private static void copy(int[] a, int[] b, int left, int right) {
        for (int i = left; i <= right; i++) {
            b[i] = a[i];
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 3, 2};
        for (int num : countArray(array)) {
            System.out.println(num);
        }
    }
}
