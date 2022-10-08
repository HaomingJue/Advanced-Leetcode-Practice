package special;

public class HopGame {
    public static void main(String[] args) {
        /*
        1 2 3 4
        5 6 7 8
        9 10 11 12
         */
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dirKey = 0;
        int i = 0, j = 0;
        int last;
        while(true) {
            last = matrix[i][j];
            System.out.println(last);
            visited[i][j] = true;
            int i1 = i + directions[dirKey][0] * 2;
            int j1 = j + directions[dirKey][1] * 2;
            if (withinRange(matrix, i1, j1) && !visited[i1][j1]) {
                i = i1;
                j = j1;
                continue;
            }
            int i2 = i + directions[dirKey][0];
            int j2 = j + directions[dirKey][1];
            dirKey = (dirKey + 1) % 4;
            i2 = i2 + directions[dirKey][0];
            j2 = j2 + directions[dirKey][1];
            if (withinRange(matrix, i2, j2) && !visited[i2][j2]) {
                i = i2;
                j = j2;
                continue;
            }
            int i3 = i + directions[dirKey][0] * 2;
            int j3 = j + directions[dirKey][1] * 2;
            if (withinRange(matrix, i3, j3) && !visited[i3][j3]) {
                i = i3;
                j = j3;
                continue;
            }
            int i4 = i + directions[dirKey][0];
            int j4 = j + directions[dirKey][1];
            dirKey = (dirKey + 1) % 4;
            i4 = i4 + directions[dirKey][0];
            j4 = j4 + directions[dirKey][1];
            if (withinRange(matrix, i4, j4) && !visited[i4][j4]) {
                i = i4;
                j = j4;
                continue;
            }
            break;
        }
        System.out.println(last);
    }

    private static boolean withinRange(int[][] matrix, int i, int j) {
        return i < matrix.length && j < matrix[0].length && i >=0 && j >= 0;
    }
}
