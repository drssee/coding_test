/**
 * 최대 도네이션 값
 * 각 이웃의 기부금은 donations이며
 * 바로 인접한 이웃이 기부를 할 경우 해당 주민은 기부를 하지 않는다
 * 최대 기부금을 구해라
 */
public class BadNeighbors {
    public static void main(String[] args) {
        System.out.println(maxDonations());
    }
    static int[] donations = {10, 3, 2, 5, 7, 8};
//    static int[] donations = {1,2,3,4,5,1,2,3,4,5};
//    static int[] donations = {11, 15, 100, 200, 300, 1};
    static int[] dp = new int[donations.length + 1];
    static int maxDonations() {
        // 길이가 5이하일땐 지금 로직으로 처리할 수 없음.. 나중에 수정하자
        if (donations.length <= 5) {
            return -1;
        }
        // 최대 도네이션 값
        int res = -1;

        // 1. 1번째 집에서 시작
        for (int i=0; i<donations.length - 1; i++) {
            if (i == 0) dp[i] = donations[0];
            if (i == 1) dp[i] = 0;
            if (i == 2) dp[i] = dp[i-2] + donations[i];
            if (i > 2) {
                dp[i] = (Math.max(dp[i-3], dp[i-2])) + donations[i];
                res = Math.max(res, dp[i]);
            }
        }
        dp = new int[donations.length + 1];

        // 2. 2번째 집에서 시작
        for (int j=1; j<donations.length; j++) {
            if (j == 1) dp[j] = donations[j];
            if (j == 2) dp[j] = 0;
            if (j == 3) dp[j] = dp[j-2] + donations[j];
            if (j > 3) {
                dp[j] = (Math.max(dp[j-3], dp[j-2])) + donations[j];
                res = Math.max(res, dp[j]);
            }
        }
        dp = new int[donations.length + 1];

        // 3. 3번째 집에서 시작
        //  3-1. 1번째 집 도네 > 마지막 집 도네
        if (donations[0] > donations[donations.length - 1]) {
            dp[0] = donations[0];
            for (int k=2; k<donations.length-1; k++) {
                if (k == 2) dp[k] = dp[k-2] + donations[k];
                if (k > 3) {
                    dp[k] = (Math.max(dp[k-3], dp[k-2])) + donations[k];
                    res = Math.max(res, dp[k]);
                }
            }
        }
        //  3-2. 그렇지 않을 경우
        else {
            for (int l=2; l<donations.length-2; l++) {
                if (l == 2) dp[l] = donations[donations.length-1] + donations[l];
                if (l > 3) {
                    dp[l] = (Math.max(dp[l-3], dp[l-2])) + donations[l];
                    res = Math.max(res, dp[l]);
                }
            }
        }

        return res;
    }
}
