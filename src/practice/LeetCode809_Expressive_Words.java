package practice;

public class LeetCode809_Expressive_Words {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStrechy(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStrechy(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            else {
                int count_s = 1;
                while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    count_s++;
                }
                int count_w = 1;
                while (j < word.length() - 1 && word.charAt(j) == word.charAt(j + 1)) {
                    j++;
                    count_w++;
                }
                if (count_s < count_w) {
                    return false;
                }
                if (count_s > count_w && count_s < 3) {
                    return false;
                }
                i++;
                j++;
            }
        }
        if (j < word.length()) {
            return false;
        }
        if (i < s.length()) {
            return false;
        }

        return true;
    }
}
