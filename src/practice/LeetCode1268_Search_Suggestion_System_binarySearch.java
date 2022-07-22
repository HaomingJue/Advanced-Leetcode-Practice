package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1268_Search_Suggestion_System_binarySearch {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ret = new ArrayList<>();
        String prefix = new String();
        int preStart = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            prefix += searchWord.charAt(i);
            int start = binarySearch(products, prefix, preStart);
            List<String> tempList = new ArrayList<>();
            for (int k = start; k < Math.min(products.length, start + 3); k++) {
                if (prefix.length() <= products[k].length() && products[k].substring(0, prefix.length()).equals(prefix)) {
                    tempList.add(products[k]);
                } else {
                    break;
                }
            }
            ret.add(tempList);
            preStart = start;
        }
        return ret;
    }

    private int binarySearch(String[] products, String prefix, int preStart) {
        int l = preStart, h = products.length - 1, m = preStart;
        while (l < h) {
            m = l + (h - l) / 2;
            if (products[m].compareTo(prefix) >= 0) {
                h = m;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }
}
