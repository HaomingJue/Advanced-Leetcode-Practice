package practice;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1288_Remove_Covered_Intervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 1;
        Arrays.sort(intervals, new IntervalComparator());
        int[] preInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (preInterval[0] <= intervals[i][0] && preInterval[1] >= intervals[i][1]) {
                continue;
            }
            else {
                count++;
                preInterval = intervals[i];
            }
        }
        return count;
    }

    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            else {
                return b[1] - a[1];
            }
        }
    }
}
