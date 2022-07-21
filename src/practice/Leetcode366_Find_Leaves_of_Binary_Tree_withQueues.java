package practice;

import utils.TreeNode;

import java.util.*;

public class Leetcode366_Find_Leaves_of_Binary_Tree_withQueues {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map, queue);
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr == root) break;
                TreeNode parent = map.get(curr);
                if (parent.left == curr) {
                    parent.left = null;
                }
                if (parent.right == curr) {
                    parent.right = null;
                }
                if (parent.right == null && parent.left == null) {
                    queue.add(parent);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    private void dfs(TreeNode node, HashMap<TreeNode, TreeNode> map, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
            dfs(node.left, map, queue);
        }
        if (node.right != null) {
            map.put(node.right, node);
            dfs(node.right, map, queue);
        }
        if (node.left == null && node.right == null) {
            queue.add(node);
        }
    }
}
