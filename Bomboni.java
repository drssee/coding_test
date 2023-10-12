import java.util.Arrays;

public class Bomboni {
    public static void main(String[] args) {
        System.out.println(getMaxCount());
    }
//    static String[] NxN = {
//            "CCP",
//            "CCP",
//            "PPC"
//    };
//    static String[] NxN = {
//            "PPPP",
//            "CYZY",
//            "CCPY",
//            "PPCC"
//    };
    static String[] NxN = {
            "YCPZY",
            "CYZZP",
            "CCPPP",
            "YCYZC",
            "CPPZZ"
    };
    static int getMaxCount() {
        //0 <-> 1 / 1 <-> 2
        //각행의 색깔 순서를 바꾸면서
        //행,열중에 최대 색깔 갯수를 저장
        int max = -1;
        for (int i=0; i<NxN.length; i++) {
            for (int j=0; j<NxN[i].length()-1; j++) {
//                if (NxN[i].charAt(j) == NxN[i].charAt(j+1)) continue;
                String[] copy = Arrays.copyOf(NxN, NxN.length);
                char[] charArray = copy[i].toCharArray();
                char temp = charArray[j];
                charArray[j] = charArray[j+1];
                charArray[j+1] = temp;
                copy[i] = new String(charArray);
                //i의 012
                //j의 i012
                //j+1의 012
                char prev1 = ' ';
                int[] maxResult1 = new int[10];
                int maxResultCount1 = 0;
                for (int k=0; k<NxN.length; k++) {
                    if (prev1 == copy[i].charAt(k)) {
                        maxResult1[maxResultCount1]++;
                    } else {
                        maxResultCount1++;
                    }
                    prev1 = copy[i].charAt(k);
                }
                max = Math.max(max, Arrays.stream(maxResult1).max().getAsInt());

                char prev2 = ' ';
                int[] maxResult2 = new int[10];
                int maxResultCount2 = 0;
                char prev3 = ' ';
                int[] maxResult3 = new int[10];
                int maxResultCount3 = 0;
                for (int l=0; l<NxN.length; l++) {
                    if (prev2 == copy[l].charAt(j)) {
                        maxResult2[maxResultCount2]++;
                    } else {
                        maxResultCount2++;
                    }
                    prev2 = copy[l].charAt(j);

                    if (prev3 == copy[l].charAt(j+1)) {
                        maxResult3[maxResultCount3]++;
                    } else {
                        maxResultCount3++;
                    }
                    prev3 = copy[l].charAt(j+1);
                }
                max = Math.max(max, Arrays.stream(maxResult2).max().getAsInt());
                max = Math.max(max, Arrays.stream(maxResult3).max().getAsInt());
            }
        }
        return max+1;
    }
}
