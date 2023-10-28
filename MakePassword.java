import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakePassword {
    public static void main(String[] args) {
        getPassword();
        System.out.println(result);
    }
    static int L = 4;
    static List<String> arr = new ArrayList<>(List.of(new String[]{"a", "t", "c", "i", "s", "w"}));
    static List<String> aeiou =new ArrayList<>(List.of(new String[]{"a", "e", "i", "o", "u"}));
    static List<String> result = new ArrayList<>();
    static void getPassword() {
        Collections.sort(arr);
        //a c i s t w

        for (int i=0; i<=(arr.size()-L); i++) {
            dfs(0, i, arr.get(i));
        }
    }
    static void dfs(int depth, int startIdx, String password) {
        if (depth == (L - 1) && !"".equals(password) && password != null) {
            boolean sw = false;
            for (String vowel : aeiou) {
                if (password.contains(vowel)) {
                    sw = true;
                    break;
                }
            }
            if (sw) result.add(password);
            return;
        }

        for (int i=startIdx+1; i<arr.size(); i++) {
            dfs(depth + 1, i, password + arr.get(i));
        }
    }
}
