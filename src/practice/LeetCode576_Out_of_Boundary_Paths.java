package practice;

public class LeetCode576_Out_of_Boundary_Paths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long count = 0;
        int modulo = 1000000007;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        long[][] pathCount = new long[m][n];
        pathCount[startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            long[][] tmp = new long[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (pathCount[j][k] != 0) {
                        for (int[] dir : directions) {
                            int j_ = j + dir[0];
                            int k_ = k + dir[1];
                            if (j_ >= 0 && j_ < m && k_ >= 0 && k_ < n) {
                                tmp[j_][k_] += pathCount[j][k];
                                tmp[j_][k_] %= modulo;
                            }
                            else {
                                count += pathCount[j][k];
                                count %= modulo;
                            }
                        }
                    }
                }
            }
            pathCount = tmp;
        }
        return (int)count;
    }
}
