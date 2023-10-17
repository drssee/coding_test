public class Nm4 {
    public static void main(String[] args) {
        getNM();
    }
    static int N = 3;
    static int M = 3;
    static int[] result = new int[M];
    static void getNM() {
        dfs(0);
    }
    private static void dfs(int length) {
        if (length == M) {
            for (int i=0; i< result.length; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }
        for (int i=0; i<N; i++) {
            if (length > 0 && result[length - 1] > i+1) continue;
            result[length] = i+1;
            dfs(length + 1);
        }
    }
}
