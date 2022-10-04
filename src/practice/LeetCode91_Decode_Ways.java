package practice;

import java.util.HashMap;

public class LeetCode91_Decode_Ways {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return numDecodings(s, 0, memo);
    }

    private int numDecodings(String s, int index, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        int count = numDecodings(s, index + 1, memo);
        int code = (s.charAt(index) - '0')* 10 + s.charAt(index + 1) - '0';
        if (code <= 26) {
            count += numDecodings(s, index + 2, memo);
        }
        memo.put(index, count);
        return count;
    }
}
