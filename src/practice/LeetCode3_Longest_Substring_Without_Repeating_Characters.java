package practice;

import java.util.HashMap;

public class LeetCode3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
            }
            else {
                int index = map.get(c);
                if (index < startIndex) {
                    map.put(c, i);
                }
                else {
                    startIndex = index + 1;
                    map.put(c, i);
                }
            }
            maxLen = Math.max(i - startIndex + 1, maxLen);
        }
        return  maxLen;
    }
}
