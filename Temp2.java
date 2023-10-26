public class Temp2 {
    public static void main(String[] args) {
        getMaxCount();
        System.out.println(maxCount);
    }
    static int N = 8;
    static int[] queens = new int[N];
    static int maxCount = 0;
    static void getMaxCount() {
        dfs(0);
    }
    static void dfs(int depth) {
        if (depth == N) {
            maxCount++;
            return;
        };

        for (int i=0; i<N; i++) {
            queens[depth] = i;
            if ((depth == 0 && i == 0) || check(depth, i)) {
                dfs(depth + 1);
            }
        }
    }
    static boolean check(int depth, int col) {
        for (int i=0; i<depth; i++) {
            if (queens[i] == col) {
                return false;
            }
            if (Math.abs(depth - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }
}