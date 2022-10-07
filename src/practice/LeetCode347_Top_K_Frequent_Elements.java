package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode347_Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, ArrayList<Integer>> freqMap = new HashMap<>();
        for (Integer num : numMap.keySet()) {
            int freq = numMap.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(num);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (Integer cur : freqMap.keySet()) {
            pq.add(cur);
        }
        int[] ans = new int[k];
        int i = 0;
        while (i < k) {
            int curFreq = pq.poll();
            ArrayList<Integer> curList = freqMap.get(curFreq);
            for (Integer num : curList) {
                ans[i++] = num;
            }
        }
        return ans;
    }
}
