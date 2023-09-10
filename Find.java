public class Find {
    public static void main(String[] args) {
        String s0 = "abab";
        String s1 = "abcccc";
        String s2 = "abacaba";
        String s3 = "qwerty";
        String s4 = "abdfhdyrbdbsdfghjkllkjhgfds";
        System.out.println(new Find().find("abab"));
    }
    public int find(String s) {
        int result = s.length();
        int end = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            if (s.charAt(start) == s.charAt(end)) {
                end--;
            } else {
                result++;
            }
        }
        return result;
    }
}
