public class OneTwoThree {
    public static void main(String[] args) {
        result[0] = 0;
        result[1] = 1; //num 1일 경우 1가지
        result[2] = 2; //num 2일 경우 2가지
        result[3] = 4; //num 3일 경우 4가지

        System.out.println(cases(10));
    }
    static int[] result = new int[11];
    public static int cases(int num) {
        for (int i=4; i<=10; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        return result[num];
    }
}
