import java.util.*;

public class SafeArea {
    public static void main(String[] args) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = false;
            }
        }
        getSafeArea();
        Collections.sort(safeAreas);
        System.out.println(safeAreas);
    }
    static int[][] area = {
            {6,8,2,6,2},
            {3,2,3,4,6},
            {6,7,3,3,2},
            {7,2,5,3,6},
            {8,9,5,2,7}
    };
    static boolean[][] board = new boolean[area.length][area[0].length];
    static int N = 4;
    static int[] vr = {1,-1,0,0};
    static int[] vc = {0,0,-1,1};
    static List<Integer> safeAreas = new ArrayList<>();

    public static void getSafeArea() {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (area[i][j] > N && !board[i][j]) {
                    Queue<int[]> nv = new LinkedList<>();
                    nv.add(new int[]{i,j});
                    int res = 1;

                    while(!nv.isEmpty()) {
                        int[] poll = nv.poll();
                        int row = poll[0];
                        int col = poll[1];
                        board[row][col] = true;

                        for (int k=0; k<4; k++) {
                            int newRow = row + vr[k];
                            int newCol = col + vc[k];
                            if (newRow < 0 || newRow >= 5 || newCol < 0 || newCol >= 5) {
                                continue;
                            }
                            if (area[newRow][newCol] > N && !board[newRow][newCol]) {
                                res++;
                                nv.add(new int[]{newRow, newCol});
                            }
                        }
                    }

                    if (res >= 1) {
                        safeAreas.add(res);
                    }
                }
            }
        }
    }
}
