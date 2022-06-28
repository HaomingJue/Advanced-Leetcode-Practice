package practice;

import java.util.Arrays;

public class LeetCode1577_NUmber_of_Ways_Where_Square_of_Number_Is_Equal_to_Product_of_Two_Numbers {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        count += countTriplets(nums1, nums2);
        count += countTriplets(nums2, nums1);
        return count;
    }

    private int countTriplets(int[] nums1, int[] nums2) {
        int count = 0;
        if (nums1.length < 2) {
            return 0;
        }
        for (int k = 0; k < nums2.length; k++) {
            int i = 0;
            int j = nums1.length - 1;
            long x = (long)nums2[k] * (long)nums2[k];
            while(i < j) {
                long y = (long)nums1[i] * (long)nums1[j];
                if (y < x) {
                    i++;
                }
                else if (y > x) {
                    j--;
                }
                else if (nums1[i] != nums1[j]) {
                    int i_next = i;
                    int j_next = j;
                    while (nums1[i_next] == nums1[i]) {
                        i_next++;
                    }
                    while (nums1[j_next] == nums1[j]) {
                        j_next--;
                    }
                    count += (i_next - i) * (j - j_next);
                    i = i_next;
                    j = j_next;
                }
                else {
                    int gap = j - i + 1;
                    count += (gap - 1)*gap/2;
                    break;
                }
            }
        }
        return count;
    }
}
