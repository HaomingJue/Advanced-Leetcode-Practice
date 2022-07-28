package practice;

public class LeetCode53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < nums.length) {
            sum += nums[j];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                j++;
                i = j;
                sum = 0;
                continue;
            }
            else {
                j++;
            }

        }
        return maxSum;
    }
}
