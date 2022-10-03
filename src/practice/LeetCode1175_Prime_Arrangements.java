package practice;

public class LeetCode1175_Prime_Arrangements {
    public int numPrimeArrangements(int n) {
        if (n < 3) return 1;
        int count = 1;
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        long ans = 1;
        for (int i = count; i >= 1; i--) {
            ans = (ans * i) % 1000000007;
        }
        for (int i = n - count; i >= 1; i--) {
            ans = (ans * i) % 1000000007;
        }
        return (int)ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

