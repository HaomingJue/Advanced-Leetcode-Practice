package practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1239_Maximum_Length_of_a_Concatenated_String_with_unique_Characters {
    public int maxLength(List<String> arr) {
        return dfs(arr, 0, "");
    }

    private int dfs(List<String> arr, int pos, String prefix) {
        Set<Character> prefixSet = new HashSet<>();
        for (char c : prefix.toCharArray()) {
            prefixSet.add(c);
        }
        if (prefixSet.size() != prefix.length()) {
            return 0;
        }
        int maxLen = prefix.length();
        for (int i = pos; i < arr.size(); i++) {
            maxLen = Math.max(maxLen, dfs(arr, i + 1, prefix + arr.get(i)));
        }
        return maxLen;
    }
}
