package practice;

public class LeetCode64_Minimum_Path_Sum {
    /*
    Dynamic Programming
    min(tol_p(x, y)) = p(x, y) + min(tol_p(x, y - 1), tol_p(x - 1, y))
    */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                }
                else if (i == 0) {
                    grid[0][j] += grid[0][j - 1];
                }
                else if (j == 0) {
                    grid[i][0] += grid[i - 1][0];
                }
                else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
