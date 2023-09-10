import java.util.*;
import java.util.stream.Collectors;

public class TheNumber {
    public static void main(String[] args) {
        TheNumber theNumber = new TheNumber();
        theNumber.init();
        String answer = "NYNY";
        Set<Integer> res = theNumber.theNumber(answer);
        System.out.println(res.toString());
    }

    List<Integer> card1 = new ArrayList<>();
    List<Integer> card2 = new ArrayList<>();
    List<Integer> card3 = new ArrayList<>();
    List<Integer> card4 = new ArrayList<>();
    List<List<Integer>> card = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public void init() {
        card1 = Arrays.stream(new int[]{1,2,3,4,5,6,7,8})
                .boxed()
                .collect(Collectors.toList());
        card2 = Arrays.stream(new int[]{1,2,3,4,9,10,11,12})
                .boxed()
                .collect(Collectors.toList());
        card3 = Arrays.stream(new int[]{1,2,5,6,9,10,13,14})
                .boxed()
                .collect(Collectors.toList());
        card4 = Arrays.stream(new int[]{1,3,5,7,9,11,13,15})
                .boxed()
                .collect(Collectors.toList());
        card.add(card1);
        card.add(card2);
        card.add(card3);
        card.add(card4);
        result = Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})
                .boxed()
                .collect(Collectors.toList());
    }

    public Set<Integer> theNumber(String answer) {
        Set<Integer> r = new HashSet(result);
        for (int i = 0; i < answer.length(); i++) {
            char a = answer.charAt(i);
            Set<Integer> cardSet = new HashSet<>(card.get(i));
            if (a == 'Y') {
                r.retainAll(cardSet);
            } else {
                r.removeAll(cardSet);
            }
        }
        return r;
    }
}
