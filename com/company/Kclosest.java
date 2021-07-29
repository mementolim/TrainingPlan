package com.company;

public class Kclosest {
    public static int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return null;
        }
        if (k >= array.length) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;
            }else {
                left = mid;
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (i < k && left >= 0 && right < array.length) {
            if (Math.abs(target - array[left]) > Math.abs(target - array[right])) {
                result[i++] = array[right++];
            }else {
                result[i++] = array[left--];
            }
        }
        while (i < k && left >= 0) {
            result[i++] = array[left--];
        }
        while (i < k && right < array.length) {
            result[i++] = array[right++];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5};
        int[] b = ( kClosest(a, 10, 3));
        for (int c : b) {
            System.out.println(c);
        }
        //aaaaaaaaa
    }
}
