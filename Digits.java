import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Digits {
    public static void main(String[] args) {
        System.out.println(new Digits().digits(10));;
    }

    public Set<Integer> digits(int base) {
        Set<Integer> result = new HashSet<>();
        for(int i=2;i<base;i++){
            boolean ok = true;
            for(int j=0;j<base;j++){
                for(int k=0;k<base;k++){
                    for(int l=0;l<base;l++) {
                        int tmp = j + k*base + l*base*base;
                        if (tmp % i == 0 && (j+k+l) % i !=0) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) break;
                }
                if (!ok) break;
            }
            if (ok) result.add(i);
        }
        return result;
    }
}
