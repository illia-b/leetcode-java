import java.util.Arrays;

class Solution00392 {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sl = s.length();
        int tl = t.length();
        int si = 0;
        int ti = 0;
        while (si < sl) {
            if (ti == tl) return false;
            if (sChars[si] == tChars[ti]) {
                si++;
            }
            ti++;
        }
        return true;
    }

    private static String[][] tests = {
            {"abc", "acbxce"},
            {"abcde", "acbxcede"},
            {"axc", "acbec"},
    };

    public static void main(String[] args) {
        var sol = new Solution00392();
        for (int i = 0; i < tests.length; i++) {
            System.out.println("running test " + i);
            runTest(sol, tests[i]);
        }
    }

    private static void runTest(Solution00392 sol, String[] test) {
        System.out.println("input");
        System.out.println(Arrays.toString(test));
        System.out.println("output");
        System.out.println(sol.isSubsequence(test[0], test[1]));
    }}
