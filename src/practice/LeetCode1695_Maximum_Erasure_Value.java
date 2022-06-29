package practice;

import java.util.HashMap;

public class LeetCode1695_Maximum_Erasure_Value {
    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int curScore = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                curScore += nums[i];
            }
            else {
                int newStart = map.get(nums[i]);
                for (int j = start; j <= newStart; j++) {
                    map.remove(nums[j]);
                    curScore -= nums[j];
                }
                map.put(nums[i], i);
                curScore += nums[i];
                start = newStart + 1;
            }
            if (curScore > maxScore) {
                maxScore = curScore;
            }
        }
        return maxScore;
    }
}
