import java.util.Arrays;

public class Boj1912 {
    public static void main(String[] args) {
        System.out.println(getAns(arr2));
    }
    static int[] arr1 = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
    static int[] arr2 = {2, 1, -4, 3, 4, -4, 6, 5, -5, 1};
    static int[] dp = new int[10];

    public static int getAns(int[] arr) {
        dp[0] = arr[0];
        for (int i=1; i<arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            System.out.println(Arrays.toString(dp));
        }
        Arrays.sort(dp);
        return dp[arr.length - 1];
    }
}
