package practice;

import java.util.ArrayList;

public class LeetCode792_Number_of_Matching_Subsequences {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        ArrayList<String>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (String word : words) {
            buckets[word.charAt(0) - 'a'].add(word);
        }
        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> tempList = buckets[s.charAt(i)-'a'];
            buckets[s.charAt(i)-'a'] = new ArrayList<>();
            for (String word : tempList) {
                word = word.substring(1);
                if (word.length() == 0) {
                    count++;
                }
                else {
                    buckets[word.charAt(0) - 'a'].add(word);
                }
            }
        }
        return count;
    }
}
