package practice;

import java.util.Arrays;

public class LeetCode253_Meeting_Rooms_II_OptimizedSolution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 1;
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(start[i]<end[last]){
                count++;
            }
            else{
                last++;
            }
        }
        return count;
    }
}
