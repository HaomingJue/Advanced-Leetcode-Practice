package practice;

import java.util.Stack;

public class LeetCode394_Decode_String {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (isDigit(c)) {
                k = k * 10 + c - '0';
            }
            else if (c == '[') {
                stringStack.push(currentString);
                currentString = new StringBuilder();
                countStack.push(k);
                k = 0;
            }
            else if (c == ']') {
                int count = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int j = 0; j < count; j++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }
            else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
