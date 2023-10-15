public class Nm3 {
    public static void main(String[] args) {
        getNM();
    }
    static int N = 4;
    static int M = 2;
    //결과
    static int[] result = new int[M];
    static void getNM() {
        dfs(0);
    }
    static void dfs(int length) {
        if (length == M) {
            for (int j=0; j<result.length; j++) {
                System.out.print(result[j]);
            }
            System.out.println();
            return;
        }
        for (int i=0; i<N; i++) {
            result[length] = i+1;
            dfs(length+1);
        }
    }
}
