package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode56_Merge_Intervals {
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        ArrayList<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                ans.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            else {
                end = Math.max(intervals[i][1], end);
            }
        }
        ans.add(new int[] {start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}
