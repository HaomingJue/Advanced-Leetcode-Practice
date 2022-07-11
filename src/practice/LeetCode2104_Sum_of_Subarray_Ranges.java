package practice;

public class LeetCode2104_Sum_of_Subarray_Ranges {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int max, min;
        for (int i = 0; i < nums.length; i++) {
            max = nums[i];
            min = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }
}
