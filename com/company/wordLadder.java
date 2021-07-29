package com.company;

import java.util.*;

public class wordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Write your solution here
        HashSet<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        q.offer(beginWord);
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                char[] array = cur.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (array[i] == j) {
                            continue;
                        }
                        array[i] = j;
                        String tmp = new String(array);
                        if (tmp.equals(endWord)) {
                            return result + 1;
                        }
                        if (dict.contains(tmp) && !visited.contains(tmp)) {
                            q.offer(tmp);
                            visited.add(tmp);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
    public static void main(String args[]) {
        String a = "bd";
        String b = "dc";
        List<String> c = new ArrayList<>();
        String[] d = new String[]{"bd","dc","dd","ca"};
        for (String s : d) {
            c.add(s);
        }
        System.out.println(ladderLength(a, b, c));
    }
}
