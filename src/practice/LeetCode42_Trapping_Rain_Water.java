package practice;

public class LeetCode42_Trapping_Rain_Water {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int volumn = 0;
        int i = 0, j = height.length - 1;
        while (i <= j) {
            if (leftMax < rightMax) {
                if (height[i] > leftMax) {
                    leftMax = height[i];
                }
                else {
                    volumn += leftMax - height[i];
                }
                i++;
            }
            else {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
                else {
                    volumn += rightMax - height[j];
                }
                j--;
            }
        }
        return volumn;
    }
}
