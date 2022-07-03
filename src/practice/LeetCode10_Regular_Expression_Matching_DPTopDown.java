package practice;

public class LeetCode10_Regular_Expression_Matching_DPTopDown {
    public boolean isMatch(String s, String p) {
        int[][] helper = new int[s.length() + 1][p.length() + 1];
        return dp(helper, s, 0, p, 0);
    }

    private boolean dp(int[][] helper, String s, int i, String p, int j) {
        if (helper[i][j] != 0) {
            return (helper[i][j] == 1);
        }
        boolean ans;
        if (j == p.length()) {
            ans = (i == s.length());
        } else {
            boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                ans = firstMatch && dp(helper, s, i+1, p, j) || (dp(helper, s, i, p, j+2));
            } else {
                ans = firstMatch && dp(helper, s, i+1, p, j+1);
            }
        }
        if (ans) {
            helper[i][j] = 1;
        } else{
            helper[i][j] = -1;
        }

        return ans;
    }
}
