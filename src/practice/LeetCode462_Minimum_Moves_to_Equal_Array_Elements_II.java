package practice;

import java.util.Arrays;

public class LeetCode462_Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int sum = 0;
        while (i < j) {
            sum += nums[j] - nums[i];
            j--;
            i++;
        }
        return sum;
    }
}
