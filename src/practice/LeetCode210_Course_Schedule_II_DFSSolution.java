package practice;

import java.util.*;

public class LeetCode210_Course_Schedule_II_DFSSolution {
    boolean flag = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] visited = new int[numCourses];

        for (int[] pair : prerequisites) {
            int source = pair[1];
            int dest = pair[0];
            List<Integer> curList = adjList.getOrDefault(source, new ArrayList<>());
            adjList.put(source, curList);
            curList.add(dest);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0)   dfs(i, visited, adjList, stack);
        }
        if (!flag) {
            return new int[0];
        }
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = stack.pop();
        }
        return order;
    }

    private void dfs(int node, int[] visited, Map<Integer, List<Integer>> adjList, Stack<Integer> stack) {
        if (!flag) {
            return;
        }
        visited[node] = 1;
        List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
        for (Integer neighbor : neighbors) {
            if (visited[neighbor] == 1) {
                flag = false;
                return;
            } else if (visited[neighbor] == 2) {
                continue;
            } else {
                dfs(neighbor, visited, adjList, stack);
            }
        }
        visited[node] = 2;
        stack.push(node);
    }
}
