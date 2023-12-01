public class Boj9095 {
    public static void main(String[] args) {
        System.out.println(getCount(10));
    }
    public static int getCount(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        return getCount(n - 3) + getCount(n - 2) + getCount(n - 1);
    }
}
