package practice;

public class LeetCode307_Range_Sum_Query_Mutable {
    private int[] tree;
    private int length;

    public LeetCode307_Range_Sum_Query_Mutable(int[] nums) {
        this.length = nums.length;
        tree = new int[length * 2];
        for (int i = 0; i < length; i++) {
            tree[length + i] = nums[i];
        }
        for (int i = length - 1; i >= 0; i--) {
            tree[i] = tree[i*2] + tree[i*2 +1];
        }
    }

    public void update(int index, int val) {
        index += length;
        tree[index] = val;
        while (index > 0) {
            tree[index / 2] = index % 2 == 0 ? tree[index] + tree[index + 1] : tree[index] + tree[index - 1];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += length;
        right += length;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}
