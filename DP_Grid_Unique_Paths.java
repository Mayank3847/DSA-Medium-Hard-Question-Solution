
public class DP_Grid_Unique_Paths {
    public static int gridUniquePath(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        int left = gridUniquePath(m, n - 1);
        int up = gridUniquePath(m - 1, n);
        return left + up;
    }

    public static int gridUniquePathMemo(int m, int n, int dp[][]) {

        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int left = gridUniquePathMemo(m, n - 1, dp);
        int up = gridUniquePathMemo(m - 1, n, dp);
        return dp[m][n] = left + up;

    }



    public static int gridUniquePathTabulation(int m, int n) {
        int dp[][] = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;

                }
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];

                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }

        }
        return dp[m - 1][n - 1];
    }

    public static int gridUniquePathSpaceOptimization(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];

            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(gridUniquePath(m - 1, n - 1));
        System.out.println(gridUniquePathMemo(m - 1, n - 1, dp));
        System.out.println(gridUniquePathTabulation(m, n));

    }

}
