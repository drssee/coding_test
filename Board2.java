public class Board2 {
    public static void main(String[] args) {
        getRoute(0,0);
    }
    public static int x = 2;
    public static int y = 2;
    public static int[][] board = new int[x+1][y+1];
    public static void getRoute(int nowX, int nowY) {
        board[nowX][nowY] = 1;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if(i!=0) board[i][j] += board[i-1][j];
                if(j!=0) board[i][j] += board[i][j-1];
            }
        }
    }
}
