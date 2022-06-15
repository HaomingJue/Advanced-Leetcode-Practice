package practice;

import utils.TreeNode;

public class LeetCode2096_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startSb = new StringBuilder();
        StringBuilder destSb = new StringBuilder();
        dfs(root, startValue, startSb);
        startSb.reverse();
        dfs(root, destValue, destSb);
        destSb.reverse();
        int i = 0, j = 0;
        for ( ; i < startSb.length() && j < destSb.length(); i++, j++) {
            if (startSb.charAt(i) == destSb.charAt(j)) {
                continue;
            }
            else {
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int k = i; k < startSb.length(); k++) {
            ans.append('U');
        }
        ans.append(destSb.substring(j));
        return ans.toString();
    }

    private boolean dfs(TreeNode root, int value, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        boolean left = dfs(root.left, value, sb);
        if (left) {
            sb.append('L');
            return true;
        }
        boolean right = dfs(root.right, value, sb);
        if (right) {
            sb.append('R');
            return true;
        }
        return false;
    }
}
