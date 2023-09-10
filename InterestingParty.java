import java.util.HashMap;
import java.util.Map;

public class InterestingParty {
    public static void main(String[] args) {
        System.out.println(new InterestingParty().bestInvitation2(
                new String[]{"sna", "programming", "cob", "monty"},
                new String[]{"py", "py", "ana", "py"}
        ));
    }

    public int bestInvitation(String[] first, String[] second) {
        int result = 1;

        for (int i = 0; i < first.length; i ++) {
            int sum1 = 1;
            int sum2 = 1;
            for (int j = 0; j < first.length; j ++) {
                if (i == j) continue;
                if (first[i].equals(first[j]) || first[i].equals(second[j])) sum1++;
            }
            for (int k = 0; k < second.length; k ++) {
                if (i == k) continue;
                if (second[i].equals(second[k]) || second[i].equals(first[k])) sum2++;
            }
            int tmp = Math.max(sum1, sum2);
            result = Math.max(tmp, result);
        }

        return result;
    }

    public int bestInvitation2(String[] first, String[] second) {
        int result = 0;

        //연관배열or맵 사용
        Map<String, Integer> resultMap = new HashMap<>();

        //해시맵 셋팅
        for (int i = 0; i < first.length; i++) {
            resultMap.put(first[i], 0);
            resultMap.put(second[i], 0);
        }

        //해시맵 리서치값 입력
        for (int j = 0; j < first.length; j++) {
            resultMap.put(first[j], resultMap.get(first[j]) + 1);
            resultMap.put(second[j], resultMap.get(second[j]) + 1);
        }

        //최대값 산출
        for (String key : resultMap.keySet()) {
            result = Math.max(resultMap.get(key), result);
        }

        return result;
    }
}
