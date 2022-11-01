package practice;

public class LeetCode1706_Where_Will_the_Ball_Fall {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dfs(grid, i, 0);
        }
        return ans;
    }

    private int dfs(int[][] grid, int col, int row) {
        if (row == grid.length) {
            return col;
        }
        int nextCol = col + grid[row][col];
        if (nextCol < 0 || nextCol >= grid[0].length || grid[row][col] != grid[row][nextCol]) {
            return -1;
        }
        return dfs(grid, nextCol, row + 1);
    }
}
