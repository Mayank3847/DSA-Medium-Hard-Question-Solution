public class DP_Climbing_Stairs {
    // BY RECURSSION ----EXPONENTIAL TIME COMPLEXITY

    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // -------MEMOIZATION------o(n)
    // --------for 3 jump ------1,2,3,;
    public static int countWaysMemo(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;

        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = countWaysMemo(n - 1, dp) + countWaysMemo(n - 2, dp) + countWaysMemo(n - 3, dp);
        return dp[n];

    }

    // ------------TABULATION ------------>O(N)
    public static int countWaysTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1] = dp[i - 1] + 0;

            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n + 1];

        System.out.println("CLIMBIMG STAIR WAYS BY RECURSION FOR 2 JUMP 1,2 : " + countWays(n));
        System.out.println("CLIMBIMG STAIR WAYS BY MEMOIZATION FOR 3 JUMP 1,2,3 : " + countWaysMemo(n, dp));
        System.out.println("CLIMBIMG STAIR WAYS BY TABULATION FOR 2 JUMP 1,2   : " + countWaysTab(n));

    }

}
