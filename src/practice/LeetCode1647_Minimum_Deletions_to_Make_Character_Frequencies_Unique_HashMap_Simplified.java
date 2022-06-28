package practice;

import java.util.HashSet;

public class LeetCode1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique_HashMap_Simplified {
    /*
O(N) time
O(1) space
*/
    public int minDeletions(String s) {
        int count = 0;
        int[] frequencies = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequencies[s.charAt(i) - 'a'] += 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (frequencies[i] > 0 && set.contains(frequencies[i])) {
                frequencies[i]--;
                count++;
            }
            if (frequencies[i] != 0) {
                set.add(frequencies[i]);
            }
        }
        return count;
    }
}
