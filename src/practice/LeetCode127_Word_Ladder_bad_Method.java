package practice;

import java.util.*;

public class LeetCode127_Word_Ladder_bad_Method {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (int i = -1; i < wordList.size(); i++) {
            String word;
            if (i == -1) {
                word = beginWord;
            }
            else {
                word = wordList.get(i);
            }
            graph.put(word, new ArrayList<>());
            for (int j = 0; j < wordList.size(); j++) {
                String target = wordList.get(j);
                if (checkWords(word, target)) {
                    graph.get(word).add(target);
                }
            }
        }
        HashMap<String, Boolean> visited = new HashMap<>();
        for (String word : wordList) {
            visited.put(word, false);
        }
        visited.put(beginWord, false);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;
        boolean found = false;
        while (!queue.isEmpty()) {
            step++;
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                String cur = queue.poll();
                visited.put(cur, true);
                List<String> nextWords = graph.get(cur);
                for (String next : nextWords) {
                    if (next.equals(endWord)) {
                        return step + 1;
                    }
                    if (!visited.get(next))    queue.add(next);
                }
            }
        }
        return 0;
    }

    private boolean checkWords(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                continue;
            }
            else {
                if (flag) return false;
                flag = true;
            }
        }
        return flag;
    }
}
