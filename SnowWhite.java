import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SnowWhite {
    public static void main(String[] args) {
        midgetHeight = Arrays.stream(new int[]{20, 7, 23, 19, 10, 15, 25, 8, 13})
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println(getSeven().stream().mapToInt(Integer::intValue).sum());
    }
    static List<Integer> midgetHeight;
    public static List<Integer> getSeven() {
        int nineSum = midgetHeight.stream().mapToInt(Integer::intValue).sum();
        int remove1 = 0;
        int remove2 = 0;
        //9개중에 2개씩 빼면서 합이 100이 되는것을 찾기
        for (int i = 0; i< midgetHeight.size(); i++) {
            for (int j = 0; j< midgetHeight.size(); j++) {
                if (i == j) continue;
                if (nineSum - midgetHeight.get(i) - midgetHeight.get(j) == 100) {
                    remove1 = midgetHeight.get(i);
                    remove2 = midgetHeight.get(j);
                    break;
                }
            }
        }
        List<Integer> result = midgetHeight;
        result.remove(Integer.valueOf(remove1));
        result.remove(Integer.valueOf(remove2));
        Collections.sort(result);
        System.out.println(result);
        return result;
    }
}
