package practice;

import utils.TreeNode;

public class LeetCode99_Recover_Binary_Search_Tree_Morris_Inorder_Traversal {
    public void recoverTree(TreeNode root) {
        // This method is to make leaf nodes' right pointers point to their nearest roots.
        // Despite modifying the original tree and creating cycles in the tree,
        // it avoids using extra space.
        TreeNode x = null, y = null, pred = null, predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;

                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                else{
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) x = pred;
                    }
                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            }
            else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) x = pred;
                }
                pred = root;
                root = root.right;
            }
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
