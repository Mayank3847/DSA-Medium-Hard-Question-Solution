public class Greedy_Valid_Parenthesis_Check {

    public static boolean validParenthesis(String str) {
        return solve(str, 0, 0);
    }

    public static boolean solve(String str, int idx, int openCnt) {
        if (idx == str.length()) {
            return openCnt == 0;
        }

        char ch = str.charAt(idx);
        if (ch == '(') {
            return solve(str, idx + 1, openCnt + 1);
        } else if (ch == ')') {
            if (openCnt == 0)
                return false;
            return solve(str, idx + 1, openCnt - 1);
        } else {
            boolean isOpen = solve(str, idx + 1, openCnt + 1);
            boolean empty = solve(str, idx + 1, openCnt);
            boolean isClose = false;
            if (openCnt > 0) {
                isClose = solve(str, idx + 1, openCnt - 1);
            }
            return empty || isOpen || isClose;
        }
    }

    public static boolean validParenthesisOptimal(String str) {
        int n = str.length();
        int low = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                low++;
                high++;

            } else if (ch == ')') {
                if (low > 0)
                    low--;
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0)
                return false;
        }
        return low == 0;
    }

    public static void main(String[] args) {
        String str = "(*)))";
        System.out.println(validParenthesis(str));
        System.out.println(validParenthesisOptimal(str));

    }

}
