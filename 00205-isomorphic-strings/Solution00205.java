import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution00205 {

    public boolean isIsomorphic(String a, String b) {
        return isRealIsomorphic(a, b) && isRealIsomorphic(b, a);
    }
    private boolean isRealIsomorphic(String s, String t) {
        Map<String, String> table = new HashMap<>();
        for (int i = 0; i< s.length(); i++ ) {
            String a = s.substring(i,i + 1);
            String b = t.substring(i, i+ 1);
            if (!table.containsKey(a)) {
                table.put(a, b);
            } else if (!b.equals(table.get(a))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution00205();
        for (int i = 0; i < tests.length; i++) {
            System.out.println("running test " + i);
            runTest(sol, tests[i]);
        }
    }

    private static void runTest(Solution00205 sol, String[] test) {
        System.out.println("input");
        System.out.println(Arrays.toString(test));
        System.out.println("output");
        System.out.println(sol.isIsomorphic(test[0], test[1]));
    }

    private static String[][] tests = {
            {"table", "cable"},
            {"egg", "add"},
            {"foo", "bar"},
            {"paper", "title"}
    };
}
