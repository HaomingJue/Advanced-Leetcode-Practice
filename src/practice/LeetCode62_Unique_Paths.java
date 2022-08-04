package practice;

public class LeetCode62_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] env = new int[m + 1][n + 1];
        int length = m + n - 2;
        env[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                env[i][j] += env[i-1][j] + env[i][j-1];
            }
        }
        return env[m][n];
    }
}
