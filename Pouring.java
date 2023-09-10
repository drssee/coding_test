import java.util.Arrays;

public class Pouring {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Pouring().thePouring2(
                        new int[]{14, 35, 86, 58, 25, 62},
                        new int[]{6, 34, 27, 38, 9, 60},
                        new int[]{1, 2, 4, 5, 3, 3, 1, 0},
                        new int[]{0, 1, 2, 4, 2, 5, 3, 1})
                )
        );
    }

    public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        for (int i = 0; i < fromId.length; i ++) {
            int fromBottle = bottles[fromId[i]];
            int toBottle = bottles[toId[i]];
            if (capacities[toId[i]] < (fromBottle + toBottle)) {
                int gap = capacities[toId[i]] - toBottle;
                bottles[fromId[i]] = bottles[fromId[i]] - gap;
                bottles[toId[i]] = capacities[toId[i]];
            } else {
                bottles[toId[i]] = fromBottle + toBottle;
                bottles[fromId[i]] = 0;
            }
        }
        return bottles;
    }

    public int[] thePouring2(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        for (int i = 0; i < fromId.length; i ++) {
            int space = capacities[toId[i]] - bottles[toId[i]];
            int vol = Math.min(space, bottles[fromId[i]]);
            bottles[fromId[i]] -= vol;
            bottles[toId[i]] += vol;
        }
        return bottles;
    }
}
