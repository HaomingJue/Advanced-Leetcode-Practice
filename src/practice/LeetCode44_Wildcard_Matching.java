package practice;

public class LeetCode44_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int tmpI = -1, starJ = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            else if (j < p.length() && p.charAt(j) == '*') {
                starJ = j;
                tmpI = i;
                j++;
            }
            else if (starJ == -1) {
                return false;
            }
            else {
                j = starJ + 1;
                i = tmpI + 1;
                tmpI = i;
            }
        }
        if (j < p.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
        }
        return true;
    }
}
