public class Nm2 {
    public static void main(String[] args) {
        getNM();
    }
    static int N = 4;
    static int M = 2;
    //사용된 숫자
    static boolean[] isUsed = new boolean[N];
    //결과 배열
    static int[] result = new int[M];
    static void getNM() {
        dfs(0, 0);
    }
    private static void dfs(int start, int length) {
        if (length == M) {
            for (int j=0; j<result.length; j++) {
                System.out.print(result[j]);
            }
            System.out.println();
            return;
        }
        for (int i=start; i<N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                if (length > 0 && result[length-1] > i+1) continue;
                result[length] = i+1;
                dfs(start+1, length+1);
                isUsed[i] = false;
            }
        }
    }

}
