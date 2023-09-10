import java.util.Arrays;

public class Encrypt {
    public static void main(String[] args) {
        System.out.println(new Encrypt().encrypt2(new int[]{1,1,1,1}));
    }

    public long encrypt(int[] numbers) {
        long max = 0;
        for(int i = 0; i < numbers.length; i ++) {
            int[] clone = Arrays.copyOf(numbers, numbers.length);
            clone[i]++;
            long tmp = 1;
            for(int j = 0; j < clone.length; j ++) {
                tmp *= clone[j];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    public long encrypt2(int[] numbers) {
        long max = 1;
        Arrays.sort(numbers);
        numbers[0]++;
        for (int i = 0; i < numbers.length; i ++) {
            max *= numbers[i];
        }
        return max;
    }
}
