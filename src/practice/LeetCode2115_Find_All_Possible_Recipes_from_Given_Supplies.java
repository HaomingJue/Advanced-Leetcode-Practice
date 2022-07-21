package practice;

import java.util.*;

public class LeetCode2115_Find_All_Possible_Recipes_from_Given_Supplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        // Create graph
        for (int i = 0; i < recipes.length; i++) {
            for (String component : ingredients.get(i)) {
                if (!graph.containsKey(component)) {
                    graph.put(component, new ArrayList<>());
                }
                graph.get(component).add(recipes[i]);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
            }
        }
        // bfs
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < supplies.length; i++) {
            queue.add(supplies[i]);
        }
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                String currSupply = queue.poll();
                if (!graph.containsKey(currSupply)) {
                    continue;
                }
                List<String> curRecipeList = graph.get(currSupply);
                for (String currRecipe : curRecipeList) {
                    int count = indegree.get(currRecipe) - 1;
                    indegree.put(currRecipe, count);
                    if (count == 0) {
                        ans.add(currRecipe);
                        queue.add(currRecipe);
                    }
                }
            }
        }
        return ans;
    }
}
