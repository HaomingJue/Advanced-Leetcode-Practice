package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode253_Meeting_Rooms_II {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval);
                continue;
            }
            List<int[]> tmpList = new ArrayList<>();
            while(!pq.isEmpty()) {
                tmpList.add(pq.poll());
            }
            boolean flag = true;
            for (int i = 0; i < tmpList.size(); i++) {
                int[] schedule = tmpList.get(i);
                if (interval[0] >= schedule[1] && flag) {
                    schedule[1] = interval[1];
                    pq.offer(schedule);
                    flag = false;
                }
                else {
                    pq.offer(schedule);
                }
            }
            if (flag) {
                pq.offer(interval);
            }
        }
        return pq.size();
    }
}
