package practice;

public class LeetCode376_Wiggle_Subsequence_dp {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] > 0) {
                up = down + 1;
            }
            else if (nums[i] - nums[i-1] < 0) {
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
}
