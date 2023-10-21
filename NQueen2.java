public class NQueen2 {
    public static void main(String[] args) {
        maxQueen();
        System.out.println(maxCount);
    }
    static int N = 8;
    static int maxCount = 0;
    static int[] queens = new int[N];
    static void maxQueen() {
        dfs(0);
    }
    static void dfs(int depth) {
        if (depth == N) {
            maxCount++;
            return;
        }

        //NxN을 N길이의 행단위로 쪼개서 한자리에 퀸을 두고
        //그밑의 행들에 퀸을 놓을 위치를 dfs
        //가능성이 없는 경우면 가지치기 = 백트래킹
        for (int i=0; i<N; i++) {
            queens[depth] = i;
            if (check(depth)) {
                dfs(depth+1);
            }
        }
    }
    static boolean check(int depth) {
        for (int i=0; i<depth; i++) {
            if (queens[depth] == queens[i]) {
                return false;
            }
            if (Math.abs(queens[depth] - queens[i]) == Math.abs(depth - i)) {
                return false;
            }
        }
        return true;
    }
}
