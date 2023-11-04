import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj2661 {
    public static void main(String[] args) {
        getGoodSequence();
        System.out.println(result);
    }
    static int N = 7;
    static List<String> otw = new ArrayList<>(Arrays.asList("1", "2", "3"));
    static List<String> result = new ArrayList<>();
    static void getGoodSequence() {
        for (int i=0; i<otw.size(); i++) {
            dfs(0, otw.get(i));
        }
    }
    static void dfs(int depth, String s) {
        if (depth == N - 1) {
            result.add(s);
            return;
        }

        for (int i=0; i<otw.size(); i++) {
            if (!isDuplicate(s, otw.get(i))) {
                dfs(depth + 1, s + otw.get(i));
            }
        }
    }

    private static boolean isDuplicate(String s, String s1) {
        //s 길이가 1일경우
        if (s.length() == 1) return s.equals(s1);

        //뒤에서 space 만큼의 문자를 잘라서 같은 길이로 비교
        String tmp = s + s1;
        int space = 1;
        while (tmp.length()/2 >= space) {
            String tmp1 = tmp.substring(tmp.length() - space);
            String tmp2 = tmp.substring(tmp.length() - space - space, tmp.length() - space);
            if (tmp1.equals(tmp2)) return true;
            space++;
        }

        return false;
    }
}
