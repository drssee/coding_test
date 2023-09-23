import java.util.Arrays;

public class Board1 {
    public static void main(String[] args) {
        System.out.println(getRoute(0,0));
        for (int i=0; i<board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    static int x = 2;
    static int y = 2;
    static int[][] board = new int[x+1][y+1];
    public static int getRoute(int nowX, int nowY) {
        if (nowX > x || nowY > y) return 0;
        if (nowX == x && nowY == y) return 1;
        if (board[nowX][nowY] != 0) return board[nowX][nowY];
        return board[nowX][nowY] = getRoute(nowX + 1, nowY) + getRoute(nowX, nowY + 1);
    }
}
