import java.util.ArrayList;
import java.util.List;

public class Eureka {
    public static void main(String[] args) {
        System.out.println(isThree(1000));
    }
    static List<Integer> list = new ArrayList<>();
    public static int isThree(int num) {
        //조합할 삼각수 배열 초기화
        for (int i = 1; i<=num; i++) {
            int tNumber = i*(i+1)/2;
            if (tNumber >= num) break;
            list.add(tNumber);
        }

        boolean sw = false;
        //list의 삼각수들을 완전 탐색으로 돌려서
        //세자리합의 경우의 수를 찾는다
        outer: for (int j = 0; j< list.size(); j++) {
            for (int k = 0; k< list.size(); k++) {
                for (int l = 0; l< list.size(); l++) {
                    int res = list.get(j) + list.get(k) + list.get(l);
                    if (res == num) {
                        sw = true;
                        break outer;
                    }
                }
            }
        }

        return sw ? 1 : 0;
    }
}
