import java.util.Arrays;

public class Boj24416 {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        pi1(N);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        pi2(N);
        long end2 = System.currentTimeMillis();

        System.out.println("pi1 call count : " + pi1CallCount + ", pi1 duration : " + (end1 - start1));
        System.out.println("pi2 call count : " + pi2CallCount + ", pi2 duration : " + (end2 - start2));
    }
    static int N = 40;
    static int pi1CallCount = 0;
    static int pi2CallCount = 0;
    static int[] pi2Result = new int[N];
    static int pi2ResultSum = 0;
    //n번째 피보나치 수 + 호출된 횟수
    //피보나치 재귀
    public static int pi1(int n) {
        pi1CallCount++;
        if (n == 1 || n == 2) return 1;
        return pi1(n - 2) + pi1(n - 1);
    }
    //피보나치 동적계획법
    public static void pi2(int n) {
        pi2CallCount++;
        for (int i=0; i<n; i++) {
            if (i == 0 || i == 1) pi2Result[i] = 1;
            else {
                pi2Result[i] = pi2Result[i - 2] + pi2Result[i - 1];
            }
            pi2ResultSum += pi2Result[i];
        }
    }
}
