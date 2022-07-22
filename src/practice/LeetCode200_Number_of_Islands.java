package practice;

public class LeetCode200_Number_of_Islands {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || grid[i][j] == '2') {
                    continue;
                }
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != '1') return;
        grid[i][j] = '2';
        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            dfs(grid, x, y);
        }
    }
}
