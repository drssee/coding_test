public class SumOfSubsequences {
    public static void main(String[] args) {
        getMaxCount();
        if (S == 0) maxCount--;
        System.out.println(maxCount);
    }
    static int N = 5;
    static int S = 0;
    static int[] arr = {-7, -3, -2, 5, 8};
    static int maxCount = 0;
    static void getMaxCount() {
        dfs(0,0);
    }
    static void dfs(int depth, int sum) {
        //depth == N개의 조합까지 조합한뒤 결과 확인
        if (depth == N) {
            if (sum == S) maxCount++;
            return;
        }

        //depth를 인덱스로 씀
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}