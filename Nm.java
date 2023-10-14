public class Nm {
    public static void main(String[] args) {
        getNM();
    }
    static int N = 4;
    static int M = 3;
    static boolean[] isVisited = new boolean[N];
    static int[] arr = new int[M];
    static void getNM() {
        dfs(0);
    }
    static void dfs(int length) {
        if (length == M) {
            for (int i=0; i<M; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        for (int i=0; i<isVisited.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[length] = i+1;
                dfs(length + 1);
                isVisited[i] = false;
            }
        }
    }
}
