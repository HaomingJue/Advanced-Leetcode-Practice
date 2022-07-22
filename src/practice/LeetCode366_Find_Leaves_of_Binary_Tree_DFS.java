package practice;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode366_Find_Leaves_of_Binary_Tree_DFS {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private int dfs(List<List<Integer>> ans, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int height = Math.max(dfs(ans, node.left), dfs(ans, node.right)) + 1;
        if (height == ans.size() + 1) {
            ans.add(new ArrayList<>());
        }
        ans.get(height - 1).add(node.val);
        return height;
    }
}
