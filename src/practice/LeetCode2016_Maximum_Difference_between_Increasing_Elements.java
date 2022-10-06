package practice;

public class LeetCode2016_Maximum_Difference_between_Increasing_Elements {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int dif = -1;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            }
            else {
                dif = Math.max(num - min, dif);
            }
        }
        return dif;
    }
}
