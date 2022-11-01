package practice;

public class LeetCode835_Image_Overlap {
    private int maxOverlap = 0;
    public int largestOverlap(int[][] img1, int[][] img2) {
        for (int i = -img1.length - 1; i <= img1.length - 1; i++) {
            for (int j = -img1[0].length - 1; j <= img1[0].length - 1; j++) {
                countOverlap(img1, img2, i, j);
            }
        }
        return maxOverlap;
    }

    private void countOverlap(int[][] img1, int[][] img2, int rowOffset, int colOffset) {
        int curOverlap = 0;
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                int row = i + rowOffset;
                int col = j + colOffset;
                if (row >= 0 && col >= 0 && row < img1.length && col < img1[0].length) {
                    if (img1[row][col] == 1 && img2[i][j] == 1) {
                        curOverlap++;
                    }
                }
            }
        }
        maxOverlap = Math.max(curOverlap, maxOverlap);
    }
}
