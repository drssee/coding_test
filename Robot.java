public class Robot {
    public static void main(String[] args) {

    }

    Boolean[][] xyChart = new Boolean[100][100];
    //동서남북 순서
    int[] vx = new int[]{1,-1,0,0};
    int[] vy = new int[]{0,0,-1,1};
    double[] prob = new double[4];

    public double getProbability(int n, int east, int west, int south, int north) {
        prob[0] = east/100.0;
        prob[1] = west/100.0;
        prob[2] = south/100.0;
        prob[3] = north/100.0;

        //초기좌표 (50,50)
        return dfs(50,50,n);
    }

    private double dfs(int x, int y, int n) {
        //탈출조건 작성
        if (xyChart[x][y]) return 0;
        if (n==0) return 1;

        double ret = 0;

        //동서남북 순회
        xyChart[x][y] = true;
        for (int i=0; i<4; i++) {
            ret += dfs(x+vx[i], y+vy[i], n-1)*prob[i];
        }
        xyChart[x][y] = false;

        return ret;
    }
}
