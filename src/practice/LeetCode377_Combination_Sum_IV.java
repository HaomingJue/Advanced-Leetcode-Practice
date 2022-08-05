package practice;

public class LeetCode377_Combination_Sum_IV {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return combs(nums, target);
    }

    private int combs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                count += combs(nums, target - nums[i]);
            }
            else {
                break;
            }
        }
        map.put(target, count);
        return count;
    }
}
