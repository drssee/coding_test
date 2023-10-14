import java.sql.Array;
import java.util.*;

public class Teaching {
    public static void main(String[] args) {
        System.out.println(getMax());
    }
    static String[] words = {
            "antarctica",
            "antahellotica",
            "antacartica"
    };
    static boolean[] isEducatedA = new boolean[26];
    static int n = 6;
    static int min = 5; //antic
    static int max = 0;
    static int getMax() {
        if (n < min) return 0;
        for (int i=0; i<words.length; i++) {
            words[i] = words[i].replaceAll("anta|tica", "");
        }

        //배운 알파벳 배열을 만들어서 진행한다
        isEducatedA['a' - 'a'] = true;
        isEducatedA['n' - 'a'] = true;
        isEducatedA['t' - 'a'] = true;
        isEducatedA['i' - 'a'] = true;
        isEducatedA['c' - 'a'] = true;

        //조합가능한 배운알파벳배열을 만들어 words와 비교한다
        dfs(0,0);
        return max;
    }

    private static void dfs(int alphabetIdx, int length) {
        if (n - min == length) {
            int count = 0;
            for (int j=0; j<words.length; j++) {
                boolean b = true;
                for (int k=0; k<words[j].length(); k++) {
                    char c = words[j].charAt(k);
                    if (!isEducatedA[c - 'a']) {
                        b = false;
                        break;
                    }
                    if (b) {
                        count++;
                    }
                }
                max = Math.max(max, count);
                return;
            }
        }
        for (int i=alphabetIdx; i<isEducatedA.length; i++) {
            if (!isEducatedA[i]) {
                isEducatedA[i] = true;
                dfs(alphabetIdx, length + 1);
                isEducatedA[i] = false;
            }
        }
    }
}
