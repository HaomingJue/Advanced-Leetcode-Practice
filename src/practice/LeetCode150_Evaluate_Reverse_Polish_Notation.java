package practice;

import java.util.Stack;

public class LeetCode150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int latter = stack.pop();
                int former = stack.pop();
                int result = calculate(former, latter, tokens[i]);
                stack.push(result);
            }
        }
        int ans = stack.pop();
        return ans;
    }

    private boolean isNumber(String str) {
        if (str.equals("/") || str.equals("+") || str.equals("-") || str.equals("*")) {
            return false;
        }
        return true;
    }

    private int calculate(int former, int latter, String operand) {
        if (operand.equals("/")) {
            return former / latter;
        }
        if (operand.equals("*")) {
            return former * latter;
        }
        if (operand.equals("+")) {
            return former + latter;
        }
        if (operand.equals("-")) {
            return former - latter;
        }
        return 1008611;
    }
}
