public class Find2 {
    public static void main(String[] args) {
        System.out.println(new Find2().find2("abcdb"));
    }
    public int find(String s) {
        //이미 회문이면 길이 리턴
        if (check(s)) return s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<s.length(); i++) {
            sb.insert(sb.length()-i, s.charAt(i));
            if (check(sb.toString())) return sb.length();
        }
        return -1;
    }

    private boolean check(String s) {
        for (int i=0; i<s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }

    public int find2(String s) {
        int result = s.length();
        int left = 0;
        int right = s.length()-1;

        //맨앞과 맨끝이 다르다면 result++후 좌측 포인터만 옮긴다
        //맨앞과 맨끝이 같다면 좌측 포인터, 우측 포인터 둘다 옮긴다
        //두 포인터가 서로 교차하거나 반복문이 끝난다면 종료
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                result++;
                left++;
            }
        }
        return result;
    }
}
