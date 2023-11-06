public class Temp3 {
    public static void main(String[] args) {
        NQueen();
        System.out.println(count);
    }
    static int N = 8;
    static int[] queen = new int[8];
    static int count = 0;
    static void NQueen() {
        dfs(0);
    }
    static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i=0; i<N; i++) {
            //depth == 행, i == 열
            queen[depth] = i; //퀸을 depth행의 i열에 놓는다
            if (check(depth)) { //다음 depth+1행에 퀸을 놓을수 있으면 탐색시작
                dfs(depth + 1);
            }
        }
    }
    static boolean check(int depth) {
        //현재 depth행에 놓은 퀸이 놓을 수 있는 자리인지 확인
        for (int i=0; i<depth; i++) {
            if (queen[depth] == queen[i]) {
                return false;
            }
            if (Math.abs(queen[depth] - queen[i]) == Math.abs(depth - i)) {
                return false;
            }
        }
        return true;
    }
}
