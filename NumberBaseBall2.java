public class NumberBaseBall2 {
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
            //모든 cases의 strike ball을 만족하는 n만이 정답이 될 수 있는 수다
            for (int i=0; i<cases.length; i++) {
                int tn = cases[i][0];
                int tf = tn/100;
                int ts = (tn - tf*100)/10;
                int tt = (tn - tf*100) - (ts*10);
                int[] tNumber = {tf,ts,tt};
                int tStrike = cases[i][1];
                int tBall = cases[i][2];
                int strike = 0;
                int ball = 0;

                //number를 반복문 돌리며 number1과 비교해서
                //같은수에 같은인덱스면 스트라이크
                //같은수이지만 다른인덱스면 볼
                for (int j=0; j<number.length; j++) {
                    for (int k=0; k<tNumber.length; k++) {
                        if (number[j] == tNumber[k]) {
                            if (j == k) {
                                strike++;
                            } else {
                                ball++;
                            }
                            break;
                        }
                    }
                }
                if (!(tStrike == strike && tBall == ball)) continue outer;
            }
            System.out.println(n);
            result++;
        }
        return result;
    }
}
