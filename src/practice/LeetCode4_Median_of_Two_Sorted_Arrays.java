package practice;

public class LeetCode4_Median_of_Two_Sorted_Arrays {
    /*
1 2 3 4 5 6 7 8 9
1 2 3 8 9
*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? getMedian(nums1, nums2) : getMedian(nums2, nums1);
    }

    private double getMedian(int[] nums1, int[] nums2) {
        int half = (nums1.length + nums2.length) / 2;
        if (nums1.length == 0) {
            return nums2.length % 2 == 0 ? (double)nums2[half-1] / 2 + (double)nums2[half] / 2 : (double)nums2[half];
        }
        int l = 0;
        int r = nums1.length - 1;
        if (nums1.length == nums2.length) {
            if (nums1[nums1.length - 1] <= nums2[0]) {
                return ((double)nums1[nums1.length-1] + (double)nums2[0]) / 2;
            }
            if (nums1[0] >= nums2[nums2.length-1]) {
                return ((double)nums2[nums2.length - 1] + (double)nums1[0]) / 2;
            }
        }

        // nums1 is completely used
        if (nums1[nums1.length - 1] <= nums2[half-nums1.length]) {
            if ((nums1.length + nums2.length) % 2 == 1)   return (double)nums2[half - nums1.length];
            else  return ((double)Math.max(nums2[half-nums1.length-1], nums1[nums1.length-1]) + (double)nums2[half - nums1.length]) / 2;
        }
        // nums1 not used
        if (nums2[half - 1]  <= nums1[0]) {
            if ((nums1.length + nums2.length) % 2 == 1)   return (double)Math.min(nums2[half], nums1[0]);
            else    return ((double)Math.min(nums1[0], nums2[half]) + (double)nums2[half - 1]) / 2;
        }
        while (true) {
            int i = l + (r - l) / 2;
            int j = half - (i + 1) - 1;
            int left1 = nums1[i];
            int right1 = nums1[i+1];
            int left2 = nums2[j];
            int right2 = nums2[j+1];
            if (left1 <= right2 && left2 <= right1) {
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return (double)Math.min(right1, right2);
                }
                else {
                    return ((double)Math.max(left1, left2) + (double)Math.min(right1, right2)) / 2;
                }
            }
            else  if (left1 > right2) {
                r = i - 1;
            }
            else if (left2 > right1) {
                l = i + 1;
            }
        }
    }
}
