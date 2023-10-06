public class NumberBaseBall {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("정답이 될수 있는 갯수: "+getNumber());
        System.out.println("걸린시간: "+(System.currentTimeMillis() - startTime));
    }
    static int[][] cases = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
    public static int getNumber() {
        int result = 0;
        outer: for (int n=123; n<=999; n++) {
            int f = n/100;
            int s = (n - f*100)/10;
            int t = (n - f*100) - (s*10);
            if (f == s || f == t || s == t) continue;
            int[] number = {f,s,t};
            //n을 기준으로 cases들을 반복문 돌리며 strike ball을 확인한다?
            for (int i=0; i<cases.length; i++) {
                int targetNumber = cases[i][0];
                int tf = targetNumber/100;
                int ts = (targetNumber - tf*100)/10;
                int tt = (targetNumber - tf*100) - (ts*10);
                int[] number1 = {tf,ts,tt};

                int strike = cases[i][1];
                int ball = cases[i][2];
                int total = strike + ball;
                if (total == 0) continue;
                if (!(checkBall(number, number1) == total
                        && checkStrike(number, number1, strike))) continue outer;
            }
            System.out.println(n);
            result++;
        }
        return result;
    }

    public static int checkBall(int[] arr1, int[] arr2) {
        int count = 0;
        // 첫 번째 배열의 각 원소를 검사하여 두 번째 배열에 있는지 확인
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                if (num1 == num2) {
                    count++;
                    break; // 중복된 숫자를 찾았으면 더 이상 검사할 필요가 없으므로 반복문 종료
                }
            }
        }
        return count;
    }

    public static boolean checkStrike(int[] arr1, int[] arr2, int count) {
        int result = 0;
        // 첫 번째 배열의 각 원소를 검사하여 두 번째 배열에 있는지 확인
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && i == j) {
                    result++;
                    break;
                }
            }
        }
        return result == count;
    }
}
