public class DP_Minimum_Insertion_To_Palindrome {
    public static int minimumInsertionRecurssion(String s) {
        int n = s.length();
        return helper(s, 0, n - 1);

    }

    public static int helper(String s, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return helper(s, left + 1, right - 1);
        } else {
            int putLeft = helper(s, left + 1, right);
            int putRight = helper(s, left, right - 1);
            return 1 + Math.min(putLeft, putRight);
        }
    }
     
//Using Memoization
  public static int minimumInsertionMemo(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return helperMemo(s, 0, n - 1, dp);
    }

    public static int helperMemo(String s, int left, int right, int[][] dp) {
        if (left >= right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        if (s.charAt(left) == s.charAt(right)) {
            dp[left][right] = helperMemo(s, left + 1, right - 1, dp);
        } else {
            int putLeft = helperMemo(s, left + 1, right, dp);
            int putRight = helperMemo(s, left, right - 1, dp);
            dp[left][right] = 1 + Math.min(putLeft, putRight);
        }

        return dp[left][right];
    }

    public static int minimumInsertionTabulation(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];


        for (int length = 2; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1];
                } else {
                    dp[left][right] = 1 + Math.min(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][n - 1];  
    }
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minimumInsertionRecurssion(s));
        System.out.println(minimumInsertionMemo(s));
        System.out.println(minimumInsertionTabulation(s));
    }

}
