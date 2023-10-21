public class Temp {
    public static void main(String[] args) {
        getMaxWords();
        System.out.println(max);
    }
    static int max = 0;
    static int K = 6;
    static String[] words = {
            "antarctica",
            "antahellotica",
            "antacartica"
    };
    //dfs로 풀기엔 너무 범위가 넓어져서 가지치기 필요함
    //그러므로 백트래킹 사용: 한번 방문한(배운) 알파벳은 다시 배울 필요가 없음
    static boolean[] isEducatedAlphabet = new boolean[26];
    static void getMaxWords() {
        //anta, tica는 모든 단어에 포함되어 있기 때문에 a, n, t, i, c는 무조건 배워야 하는 알파벳
        isEducatedAlphabet['a' - 'a'] = true;
        isEducatedAlphabet['n' - 'a'] = true;
        isEducatedAlphabet['t' - 'a'] = true;
        isEducatedAlphabet['i' - 'a'] = true;
        isEducatedAlphabet['c' - 'a'] = true;
        //words에 anta xx tica가 중복되어 들어가기 때문에 제거하여 반복 줄이기
        for (int i=0; i<words.length; i++) {
            words[i] = words[i].replaceAll("anta|tica", "");
        }
        //필수로 배워야 하는 단어 5개도 못배우는 경우면 리턴0
        if (K < 5) {
            max = 0;
            return;
        }
        //가지치기하면서 dfs실행
        dfs(0);
    }
    private static void dfs(int length) {
        //배울수 있는 단어는 전부다 배운 상황이면 비교하는 로직 실행
        if (length == (K - 5)) {
            int temp = 0;
            for (int i=0; i<words.length; i++) {
                boolean sw = true;
                for (int j=0; j<words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    //배운 단어가 아닐경우
                    if (!isEducatedAlphabet[c - 'a']) {
                        sw = false;
                        break;
                    }
                }
                //배운 단어일 경우 카운트++
                if (sw) {
                    temp++;
                }
            }
            max = Math.max(max, temp);
            return;
        }
        //알파벳들을 순회하면서 배울수 있는 알파벳 제한수 까지 배운다
        for (int l=0; l<isEducatedAlphabet.length; l++) {
            //배우지 않은 알파벳일 경우
            if (!isEducatedAlphabet[l]) {
                isEducatedAlphabet[l] = true;
                dfs(length + 1);
                isEducatedAlphabet[l] = false;
            }
        }
    }
}
