package practice;

import java.util.*;

public class LeetCode127_Word_Ladder_OptimizedBFS {
    /*
In previous solution, I traversed the word list to check if any of the target word has
one character differnce from the original one. Therefore, the time complexity grows to
O(N^2*M), where N refers to the length of word list and M refers to the length of word.
Notice that constraint of N is 5000 and constriant of word length is 10. So it's better
to store the transformation of word instead of every word in the hashmap as keys. In this
way, the time complexity is O(M^2*N), which is much better.
And space complexity can be optimized by storing the word indices instead of the word itself.
Current solution's complexity:
Time: O(M^2*N)
Space: O(N*M)
which is much better compared to previous O(N^2*M) time and O(N^2) space
*/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                String newWord = word.substring(0, j) + '*' + word.substring(j+1, word.length());
                if (!map.containsKey(newWord) ) {
                    map.put(newWord, new ArrayList<>());
                }
                map.get(newWord).add(i);
            }
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            step++;
            for (int i = 0; i < qLen; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    String newCur = cur.substring(0, j) + '*' + cur.substring(j+1, cur.length());
                    ArrayList<Integer> indexList = map.getOrDefault(newCur, new ArrayList<>());
                    for (Integer k : indexList) {
                        String nextWord = wordList.get(k);
                        if (nextWord.equals(endWord)) {
                            return step+1;
                        }
                        if (!visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.add(wordList.get(k));
                        }
                    }
                }
            }
        }
        return 0;
    }
}
