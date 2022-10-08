package practice;

public class LeetCode526_Beautiful_Arrangement {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        countArrangement(n, 1, visited);
        return count;
    }

    private void countArrangement(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (valid(pos, i)) {
                visited[i] = true;
                countArrangement(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

    private boolean valid(int pos, int i) {
        return i % pos == 0 || pos % i == 0;
    }
}
