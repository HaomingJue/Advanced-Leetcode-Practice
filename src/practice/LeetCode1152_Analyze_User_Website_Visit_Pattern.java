package practice;

import java.util.*;

public class LeetCode1152_Analyze_User_Website_Visit_Pattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Integer>> userMap = new HashMap<>();
        HashMap<List<String>, HashSet<String>> patternMap = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            if (!userMap.containsKey(username[i])) {
                userMap.put(username[i], new ArrayList<>());
            }
            userMap.get(username[i]).add(i);
        }
        for (String user : userMap.keySet()) {
            List<Integer> visitedIndex = userMap.get(user);
            Collections.sort(visitedIndex, (a, b) -> (timestamp[a] - timestamp[b]));
            if (visitedIndex.size() < 3) {
                continue;
            }
            for (int i = 0; i < visitedIndex.size() - 2; i++) {
                for (int j = i + 1; j < visitedIndex.size() - 1; j++) {
                    for (int k = j + 1; k < visitedIndex.size(); k++) {
                        List<String> tmpPattern = new ArrayList<>();
                        tmpPattern.add(website[visitedIndex.get(i)]);
                        tmpPattern.add(website[visitedIndex.get(j)]);
                        tmpPattern.add(website[visitedIndex.get(k)]);
                        if (!patternMap.containsKey(tmpPattern)) {
                            patternMap.put(tmpPattern, new HashSet<>());
                        }
                        patternMap.get(tmpPattern).add(user);
                    }
                }
            }
        }
        int maxScore = 0;
        List<String> maxPattern = new ArrayList<>();
        for (List<String> pattern : patternMap.keySet()) {
            int score = patternMap.get(pattern).size();
            if (score > maxScore) {
                maxPattern = pattern;
                maxScore = score;
            }
            if (score == maxScore) {
                for (int i = 0; i < 3; i++) {
                    if (pattern.get(i).compareTo(maxPattern.get(i)) < 0) {
                        maxPattern = pattern;
                        break;
                    }
                    else if (pattern.get(i).compareTo(maxPattern.get(i)) > 0) {
                        break;
                    }
                }
            }
        }
        return maxPattern;
    }
}
