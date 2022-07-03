package practice;

public class LeetCode926_Flip_String_to_Monotone_Increasing {
    public int minFlipsMonoIncr(String s) {
        int one = 0, flip = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                flip++;
            }
            flip = Math.min(flip, one);
        }
        return flip;
    }
}
