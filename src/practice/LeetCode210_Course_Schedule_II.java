package practice;

import java.util.*;

public class LeetCode210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            int source = pair[1];
            int dest = pair[0];
            List<Integer> curList = adjList.getOrDefault(source, new ArrayList<>());
            curList.add(dest);
            adjList.put(source, curList);
            indegree[dest] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int j = 0;
        while (!queue.isEmpty()) {
            order[j] = queue.poll();
            List<Integer> neighbors = adjList.getOrDefault(order[j], new ArrayList<>());
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                indegree[neighbor] -= 1;
                if (indegree[neighbor]  == 0) {
                    queue.add(neighbor);
                }
            }
            j++;
        }
        if (j != numCourses) {
            return new int[0];
        }
        return order;
    }
}
