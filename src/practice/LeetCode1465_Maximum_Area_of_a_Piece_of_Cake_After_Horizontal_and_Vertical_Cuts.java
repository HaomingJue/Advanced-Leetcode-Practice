package practice;

import java.util.Arrays;

public class LeetCode1465_Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int horizontalMax = 0;
        int verticalMax = 0;
        int left, right, top ,down;
        for (int i = -1; i < horizontalCuts.length; i++) {
            left = i == -1 ? 0 : horizontalCuts[i];
            right = i == horizontalCuts.length - 1 ? h : horizontalCuts[i+1];
            horizontalMax = Math.max(right - left, horizontalMax);
        }
        for (int j = -1; j < verticalCuts.length; j++) {
            top  = j == -1 ? 0 : verticalCuts[j];
            down = j == verticalCuts.length - 1 ? w : verticalCuts[j+1];
            verticalMax = Math.max(down - top, verticalMax);
        }
        long area = (long)verticalMax * (long)horizontalMax;
        return (int)(area % (1000000000+7));
    }
}
