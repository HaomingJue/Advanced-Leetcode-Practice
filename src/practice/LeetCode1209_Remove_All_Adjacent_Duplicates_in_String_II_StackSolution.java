package practice;

import java.util.Stack;

public class LeetCode1209_Remove_All_Adjacent_Duplicates_in_String_II_StackSolution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            }
            else {
                int incremented = stack.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
                else {
                    stack.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
