package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1268_Search_Suggestions_System_7_22_2022 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            int startIndex = binarySearch(products, searchWord.substring(0, i+1));
            if (startIndex == -1) {
                break;
            }
            for (int j = startIndex; j < products.length && j < startIndex+3; j++) {
                if (products[j].length() >= i+1 && products[j].substring(0, i+1).equals(searchWord.substring(0,i+1)))
                    list.add(products[j]);
            }
            ans.add(list);
        }
        return ans;
    }

    private int binarySearch(String[] products, String searchWord) {
        int l = 0, h = products.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if ( products[mid].compareTo(searchWord) < 0) {
                l = mid + 1;
            }
            else {
                h = mid;
            }
        }
        return l;
    }

}
