package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmpArr = str.toCharArray();
            Arrays.sort(tmpArr);
            String tmp = new String(tmpArr);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<String>());
            }
            map.get(tmp).add(str);
        }
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
