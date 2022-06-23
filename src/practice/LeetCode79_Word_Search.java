package practice;

public class LeetCode79_Word_Search {
    private int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(new int[board.length][board[0].length], i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int[][] visited, int i, int j, int pos) {

        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        if (pos == word.length()-1) {
            return true;
        }

        visited[i][j] = 1;
        for (int[] dir : directions) {
            int i_next = i + dir[0];
            int j_next = j + dir[1];
            if (i_next >= 0 && i_next < visited.length && j_next >= 0 && j_next < visited[0].length && visited[i_next][j_next] == 0) {
                if (search(visited, i_next, j_next, pos+1)) {
                    return true;
                }
            }
        }
        visited[i][j] = 0;
        return false;
    }
}
