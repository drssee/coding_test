public class FriendScore {
    public static void main(String[] args) {
        String[] f1 = new String[]{"NYY", "YNY", "YYN"};
        String[] f2 = new String[]{"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
        System.out.println(new FriendScore().highestScore(f2));
    }
    public int highestScore(String[] friends) {
        int result = 0;
        for (int i = 0; i < friends.length; i++) {
            int subResult = 0;

            for (int j = 0; j < friends[i].length(); j++) {
                if (friends[i].charAt(j) == 'Y') {
                    subResult++;
                    for (int k = 0; k < friends[j].length(); k++) {
                        if (i == k) continue;

                        //중복되는 직접친구일 경우는 ++ 하면 안됨
                        if (friends[j].charAt(k) == 'Y' && friends[i].charAt(k) != 'Y') {
                            subResult++;
                        }
                    }
                }
            }

            result = Math.max(result, subResult);
        }
        return result;
    }
}
