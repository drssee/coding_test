public class Boj1405 {
    public static void main(String[] args) {
        crazyRobot();
        System.out.println(result);
    }
    static int N = 2;
    static double[] percentage = {0.25, 0.25, 0.25, 0.25};
    static double result = 0L;
    static boolean[][] isVisited = new boolean[30][30];
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static void crazyRobot() {
        result = dfs(0, 15, 15);
    }
    static double dfs(int depth, int row, int col) {
        if (isVisited[row][col]) return 0L;
        if (depth == N) return 1L;

        //1.방문가능한 좌표면 방문했다 표시
        //2.해당 노드에서 각 동서남북 분기 노드들의 이동확률 합
        isVisited[row][col] = true;
        double r = 0L;
        for (int i=0; i<dr.length; i++) {
            r += percentage[i] * dfs(depth + 1, row + dr[i], col + dc[i]);
        }
        isVisited[row][col] = false;
        return r;
    }
}
