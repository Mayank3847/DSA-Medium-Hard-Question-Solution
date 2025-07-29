public class DP_Grid_Unique_Path_II {
    public static int gridUniquePathRecurssion(int mat[][], int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0 || mat[m][n] == -1) {
            return 0;
        }
        int left = gridUniquePathRecurssion(mat, m - 1, n);
        int up = gridUniquePathRecurssion(mat, m, n - 1);
        return left + up;
    }

    public static int gridUniquePathMemoization(int mat[][], int m, int n, int dp[][]) {
        if (m == 0 && n == 0) {
            return 1;

        }
        if (m < 0 || n < 0 || mat[m][n] == -1) {
            return 0;

        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int left = gridUniquePathMemoization(mat, m - 1, n, dp);
        int up = gridUniquePathMemoization(mat, m, n - 1, dp);
        return dp[m][n] = left + up;
    }

    public static int gridUniquePathTab(int mat[][], int m, int n) {
        int dp[][] = new int[m][n];
        int MOD = 1000000007;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 0 && j >= 0 && mat[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 & j == 0) {
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
                dp[i][j] = (up + left) % MOD;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int gridUniquePathSpaceOptimization(int mat[][], int m, int n) {
        int prev[] = new int[m];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i >= 0 && j >= 0 && mat[i][j] == -1) {
                    temp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = prev[j];
                }
                if (j > 0) {
                    left = temp[j - 1];
                }
                temp[j] = up + left;

            }
            prev = temp;
        }
        return prev[n - 1];
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 0 }, { 0, -1, -1 }, { 0, 0, 0 } };
        int m = 3, n = 3;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(gridUniquePathRecurssion(mat, m - 1, n - 1));
        System.out.println(gridUniquePathMemoization(mat, m - 1, n - 1, dp));
        System.out.println(gridUniquePathTab(mat, m, n));
        System.out.println(gridUniquePathSpaceOptimization(mat, m, n));
    }
}
