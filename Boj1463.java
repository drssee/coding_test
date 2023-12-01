import java.util.Arrays;

public class Boj1463 {
    public static void main(String[] args) {
        System.out.println(getMinCount(10));
    }
    static int[] dp = new int[11];
    static int getMinCount(int n) {
        if (n == 1) return 0;

        if (dp[n] == 0) {
            //3 * 2 = 6, 6으로 나누어 떨어질때
            if (n % 6 == 0) {
                dp[n] = Math.min(getMinCount(n - 1), Math.min(getMinCount(n / 3), getMinCount(n / 2))) + 1;
            }
            //3으로 나누어 떨어질때
            else if (n % 3 == 0) {
                dp[n] = Math.min(getMinCount(n - 1), getMinCount(n / 3)) + 1;
            }
            //2로 나누어 떨어질때
            else if (n % 2 == 0) {
                dp[n] = Math.min(getMinCount(n - 1), getMinCount(n / 2)) + 1;
            }
            //그외
            else {
                dp[n] = getMinCount(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
