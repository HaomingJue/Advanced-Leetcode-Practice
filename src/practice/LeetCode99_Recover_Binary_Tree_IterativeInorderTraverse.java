package practice;

import utils.TreeNode;

import java.util.Stack;

public class LeetCode99_Recover_Binary_Tree_IterativeInorderTraverse {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null, y = null, pred = null;
        boolean flag = false;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
            pred = root;
            root = root.right;
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
