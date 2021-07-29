package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class sumii {
    public static List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                result.add(Arrays.asList(map.get(target - array[i]), i));
            }
            if (!map.containsValue(i)) {
                map.put(array[i], i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = new int[]{3,5,3,2,4,4};
        System.out.println(allPairs(array, 7));
    }
}
