package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15_3Sum_Better_Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while(k > j) {
                    if (nums[j] + nums[k] == target) {
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[k]);
                        ans.add(tmpList);
                        while (j < k && nums[j] == nums[j+1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k-1]) {
                            k--;
                        }
                        j++;
                        k--;
                        continue;
                    }
                    else if (nums[j] + nums[k] < target) {
                        j++;
                    }
                    else if (nums[j] + nums[k] > target) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
