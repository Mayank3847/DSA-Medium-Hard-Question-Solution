public class MinimumWindowSubsequences {

    public static String minWindowSubseqBruteForce(String s1, String s2) {
        int minLength = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i < s1.length(); i++) {
            int s1Idx = i, s2Idx = 0;

            while (s1Idx < s1.length()) {
                if (s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
                    s2Idx++;
                    if (s2Idx == s2.length())
                        break;
                }
                s1Idx++;
            }

            if (s2Idx != s2.length())
                continue;

            int end = s1Idx;

            s2Idx = s2.length() - 1;
            while (s1Idx >= i) {
                if (s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
                    s2Idx--;
                    if (s2Idx < 0)
                        break;
                }
                s1Idx--;
            }

            int start = s1Idx + 1;
            if (end - start + 1 < minLength) {
                minLength = end - start + 1;
                result = s1.substring(start, end + 1);
            }
        }

        return result;
    }

    public static String minWindowSubseqOptimal(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int i = 0; i < m; i++) {
            int s1Idx = i;
            int s2Idx = 0;

            while (s1Idx < m) {
                if (s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
                    s2Idx++;
                    if (s2Idx == n)
                        break;
                }
                s1Idx++;
            }

            if (s2Idx != n)
                continue;

            int end = s1Idx;

            s2Idx = n - 1;
            while (s1Idx >= i) {
                if (s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
                    s2Idx--;
                    if (s2Idx < 0)
                        break;
                }
                s1Idx--;
            }

            int start = s1Idx + 1;
            if (end - start + 1 < minLen) {
                minLen = end - start + 1;
                startIndex = start;
            }
        }

        return (startIndex == -1) ? "" : s1.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        String s1 = "abcdebdde";
        String s2 = "bde";
        System.out.println(minWindowSubseqBruteForce(s1, s2));
        System.out.println(minWindowSubseqOptimal(s1, s2));
    }
}
