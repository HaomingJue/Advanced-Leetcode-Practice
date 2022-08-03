package practice;

import java.util.TreeMap;

public class LeetCode729_My_Calendar_I_TreeMap {
    private TreeMap<Integer, Integer> calendar;

    public LeetCode729_My_Calendar_I_TreeMap() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevKey = calendar.floorKey(start);
        Integer nextKey = calendar.ceilingKey(start);
        if ((prevKey == null || calendar.get(prevKey) <= start) && (nextKey == null || end <= nextKey)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
