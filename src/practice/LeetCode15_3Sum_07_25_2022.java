package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode15_3Sum_07_25_2022 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans;
        ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < nums.length - 1 && k > j) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(nums[k]);
                    set.add(tmpList);
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
        for (List<Integer> list : set) {
            ans.add(list);
        }
        return ans;
    }
}
