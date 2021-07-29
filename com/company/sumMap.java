package com.company;

import java.util.*;

public class sumMap {
    public static List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                List<Integer> cur = map.get(target - array[i]);
                for (int j = 0; j < cur.size(); j++) {
                    result.add(Arrays.asList(cur.get(j), i));
                }
            }else {
                List<Integer> tmp = map.get(array[i]);
                if (tmp == null) {
                    tmp = new ArrayList<>();
                    tmp.add(i);
                    map.put(array[i], tmp);
                }else {
                    tmp.add(i);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = new int[]{3,9,1,2,3};
        System.out.println(allPairs(array, 4));
    }
}
