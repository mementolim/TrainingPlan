package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sumclosest {
    public static List<Integer> closest(int[] array, int target) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] > target) {
                j--;
            }else if (array[i] + array[j] < target) {
                i++;
            }else {
                result.add(array[i]);
                result.add(array[j]);
                return result;
            }
        }
        if (i + 1 == array.length) {
            result.add(array[i - 1]);
            result.add(array[i]);
            return result;
        }else if (i - 1 < 0) {
            result.add(array[i]);
            result.add(array[i + 1]);
            return result;
        }
        if (Math.abs(target - (array[i - 1] + array[i])) <
                Math.abs(target - (array[i + 1] + array[i]))) {
            result.add(array[i - 1]);
            result.add(array[i]);
            return result;
        }else {
            result.add(array[i]);
            result.add(array[i + 1]);
            return result;
        }
    }
    public static void main(String args[]) {
        int[]  a = new int[]{2, -3, 9};
        System.out.println(closest(a, 4));
    }
}
