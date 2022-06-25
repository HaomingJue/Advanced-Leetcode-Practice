package practice;

import utils.TreeNode;

import java.util.ArrayList;

public class LeetCode99_Recover_Binary_Tree_IntuitiveInorderMethod {
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] swapped = findTwoSwapped(list);
        recover(root, 2, swapped);
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private int[] findTwoSwapped(ArrayList<Integer> list) {
        boolean firstElement = true;
        int x = 0, y = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                y = list.get(i+1);
                if (firstElement) {
                    x = list.get(i);
                    firstElement = false;
                }
                else {
                    return new int[] {x, y};
                }
            }
        }
        return new int[] {x, y};
    }

    private void recover(TreeNode root, int count, int[] swapped) {
        if (root == null || count == 0) {
            return;
        }
        if (root.val == swapped[0] || root.val == swapped[1]) {
            root.val = root.val == swapped[0]? swapped[1] : swapped[0];
            count--;
        }
        recover(root.left, count, swapped);
        recover(root.right, count, swapped);
    }
}
