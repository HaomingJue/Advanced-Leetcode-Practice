package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique_HashMap {
    /*
    O(N) time
    O(1) space
    */
    public int minDeletions(String s) {
        int count = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : charMap.keySet()) {
            int frequency = charMap.get(c);
            freqMap.put(frequency, freqMap.getOrDefault(frequency, 0) + 1);
        }
        Set<Integer> set = new HashSet(freqMap.keySet());
        for (Integer freq : set) {
            int charNum = freqMap.get(freq);
            while (charNum > 1) {
                for (int i = 0; i < charNum - 1; i++) {
                    charNum -= 1;
                    int new_freq = freq;
                    while (freqMap.containsKey(new_freq)) {
                        new_freq -= 1;
                        count++;
                    }
                    if (new_freq != 0) freqMap.put(new_freq, 1);
                }
            }
        }
        return count;
    }
}
