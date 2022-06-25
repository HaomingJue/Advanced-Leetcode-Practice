package practice;

import utils.TreeNode;

public class LeetCode99_Recover_Binary_Tree_RecursiveInorderTraverse {
    private TreeNode x = null, y = null, pred = null;
    private boolean flag = false;
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(x, y);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pred != null && pred.val > root.val) {
            y = root;
            if (x == null) {
                x = pred;
            }
            else {
                return;
            }
        }
        pred = root;
        inorder(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
