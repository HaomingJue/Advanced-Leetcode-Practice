package practice;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode71_Simplify_Path {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String dir : directories) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }
            else if (dir.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
                continue;
            }
            else {
                deque.addLast(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
}
