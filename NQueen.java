import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        getMaxNQueen();
        System.out.println(maxCount);
    }
    static int N = 4;
    static List<int[]> queens = new ArrayList<>();
    static int maxCount = 0;
    static void getMaxNQueen() {
        //NxN 체스판에 N개의 퀸을 서로 공격당하지 않는 범위에 놓는다
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                dfs(i,j);
                if (queens.size() == N) {
                    maxCount++;
                }
                queens = new ArrayList<>();
            }
        }
    }
    static void dfs(int x, int y) {
        if (x >= N || queens.size() >= N) return;

        if (!queens.contains(new int[]{x, y})) {
            boolean sw = true;
            //퀸이 놓여있지 않은 좌표면 퀸을 놓을 수 있는지 확인하자
            for (int i=0; i<queens.size(); i++) {
                int[] queen = queens.get(i);
                //가로 세로 체크
                if (queen[0] == x || queen[1] == y) {
                    sw = false;
                    break;
                }
                //x끼리의 차이값과 y끼리의 차이값이 같으면 대각선에 있음
                if (Math.abs(x - queen[0]) == Math.abs(y - queen[1])) {
                    sw = false;
                    break;
                }
            }
            if (sw) {
                queens.add(new int[]{x, y});
            }
        }

        if (y + 1 == N) {
            dfs(x + 1, 0);
        } else {
            dfs(x, y + 1);
        }
    }
}
