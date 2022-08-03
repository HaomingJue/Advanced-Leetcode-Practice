package practice;

import java.util.PriorityQueue;

public class LeetCode378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[] {i, 0});
        }
        int[] pos = new int[2];
        for (int i = 0; i < k; i++) {
            pos = pq.poll();
            if (pos[1] + 1 < matrix[0].length) {
                pq.offer(new int[] {pos[0], pos[1]+1});
            }
        }
        return matrix[pos[0]][pos[1]];
    }
}
