public class Salary {
    public static void main(String[] args) {
        System.out.println(totalSalary());
    }
    static String[] relations = {
        "NYNNYN",
        "NNNNNN",
        "NNNNNN",
        "NNYNNN",
        "NNNNNN",
        "NNNYYN"
    };
    static String noSub = "NNNNNN";
    static long[] salary = new long[relations.length + 1];
    static long totalSalary() {
        long res = 0L;
        for (int person=0; person<relations.length; person++) {
            res += dfs(person);
        }
        return res;
    }
    static long dfs(int person) {
        if (salary[person] != 0) return salary[person];
        if (noSub.equals(relations[person])) return salary[person] = 1L;
        long res = 0L;
        for (int i=0; i<relations[person].length(); i++) {
            if (relations[person].charAt(i) == 'Y') {
                res += dfs(i);
            }
        }
        return salary[person] = res;
    }
}
