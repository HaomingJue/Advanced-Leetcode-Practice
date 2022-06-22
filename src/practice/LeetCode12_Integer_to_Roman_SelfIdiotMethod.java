package practice;

import java.util.HashMap;
import java.util.Map;

public class LeetCode12_Integer_to_Roman_SelfIdiotMethod {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(900, "MC");
        map.put(400, "DC");
        map.put(90, "CX");
        map.put(40, "LX");
        map.put(9, "XI");
        map.put(4, "VI");
        StringBuilder sb = new StringBuilder();
        int helper = 1;
        while (num != 0) {
            int cur = num % 10 * helper;
            num = num / 10;
            if (map.containsKey(cur)) {
                sb.append(map.get(cur));
            } else {
                int half = helper * 5;
                if (cur < half) {
                    for (int i = 0; i < cur / helper; i++) {
                        sb.append(map.get(helper));
                    }
                } else {
                    cur = cur - half;
                    for (int i = 0; i < cur / helper; i++) {
                        sb.append(map.get(helper));
                    }
                    sb.append(map.get(half));
                }
            }
            helper *= 10;
        }
        return sb.reverse().toString();
    }
}
