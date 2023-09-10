import java.util.*;

public class LongestPath {
    public static void main(String[] args) {
        String[] maze = new String[]{
                "...",
                "...",
                "..."
        };
        int startRow = 0;
        int startCol = 1;
        int[] moveRow = {1,0,-1,0};
        int[] moveCol = {0,1,0,-1};
        int result = new LongestPath().longestPath(maze, startRow, startCol, moveRow, moveCol);
        System.out.println(result);
    }

    //넓이우선 코드작성 규칙
    //1.방문한 목록 큐를 만든다
    //2.무한반복문으로 큐가 empty 될때까지 돌린다

    public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        int max = 0;
        int width = maze[0].length();
        int height = maze.length;
        int[][] board = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //-1 미방문
                board[i][j] = -1;
            }
        }

        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueC = new LinkedList<>();
        queueR.add(startRow);
        queueC.add(startCol);

        board[startRow][startCol] = 0;

        while(!queueR.isEmpty()) {
            int r = queueR.poll();
            int c = queueC.poll();

            for (int i = 0; i < moveRow.length; i++) {
                int nextR = r + moveRow[i];
                int nextC = c + moveCol[i];

                //이동하려는 좌표가 미로 안에 있고
                //방문하지 않은 곳이여야 하며(최단경로이기 때문)
                //방문할수 있는 위치여야함(.)
                if ((0 <= nextR && nextR < width) && (0 <= nextC && nextC < height)
                        && board[nextR][nextC] == -1
                        && maze[nextR].charAt(nextC) == '.') {
                    board[nextR][nextC] = board[r][c] + 1;
                    queueR.add(nextR);
                    queueC.add(nextC);
                }
            }
        }


        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[k].length; l++) {
                //방문할 곳이 있는데 도달하지 못했으면 막혀서 못가는것
                if (maze[k].charAt(l) == '.' && board[k][l] == -1) {
                    return -1;
                }
                max = Math.max(max, board[k][l]);
            }
        }
        return max;
    }
}
