package practice;

import java.util.HashMap;

public class LeetCode1074_Number_of_Submatrices_That_Sum_to_Target {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix[0].length; i++) {
            for (int j = 1; j <= matrix.length; j++) {
                prefixSum[j][i] = prefixSum[j-1][i] + prefixSum[j][i-1] - prefixSum[j-1][i-1] + matrix[j-1][i-1];
            }
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r1 = 0; r1 < prefixSum.length - 1; r1++) {
            for (int r2 = r1 + 1; r2 < prefixSum.length; r2++) {
                map.clear();
                map.put(0, 1);
                for (int col = 1; col < prefixSum[0].length; col++) {
                    int sum = prefixSum[r2][col] - prefixSum[r1][col];
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
