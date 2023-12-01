import java.util.Arrays;

public class Boj9184 {
    public static void main(String[] args) {
//        System.out.println(w(15, 15,15));
        System.out.println(w2(15, 15,15));
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);

        if (a < b && b < c) return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    static int[][][] dp = new int[21][21][21];

    public static int w2(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = w2(20, 20, 20);

        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) return dp[a][b][c] = w2(a, b, c - 1) + w2(a, b - 1, c - 1) - w2(a, b - 1, c);

        return dp[a][b][c] = w2(a - 1, b, c) + w2(a - 1, b - 1, c) + w2(a - 1, b, c - 1) - w2(a - 1, b - 1, c - 1);
    }
}
