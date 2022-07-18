package practice;

public class LeetCode376_Wiggle_Subsequence_greedy {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int count;
        if (nums[0] == nums[1]) {
            count = 1;
        } else {
            count = 2;
        }
        int prevDif = nums[1] - nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int dif = nums[i+1] - nums[i];
            if (dif < 0 && prevDif >= 0 || (dif > 0 && prevDif <= 0)) {
                prevDif = dif;
                count++;
            }
        }
        return count;
    }
}
