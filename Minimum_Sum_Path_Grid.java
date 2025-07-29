public class Minimum_Sum_Path_Grid {
    public static int minimumPathSumRecurssion(int mat[][], int i, int j) {
        if (i == 0 && j == 0) {
            return mat[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);

        }
        int up = mat[i][j] + minimumPathSumRecurssion(mat, i - 1, j);
        int left = mat[i][j] + minimumPathSumRecurssion(mat, i, j - 1);
        return Math.min(up, left);

    }

    public static int minimumPathSumMemo(int mat[][], int i, int j, int dp[][]) {

        if (i == 0 && j == 0) {
            return mat[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];

        }
        int up = mat[i][j] + minimumPathSumMemo(mat, i - 1, j, dp);
        int left = mat[i][j] + minimumPathSumMemo(mat, i, j - 1, dp);
        return dp[i][j] = Math.min(up, left);
    }

    public static int minimumPathSumTabulation(int mat[][], int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = mat[i][j];

                } else {
                    int up = mat[i][j];
                    if (i > 0) {
                        up += dp[i - 1][j];
                    } else {
                        up += (int) Math.pow(10, 9);
                    }
                    int left = mat[i][j];
                    if (j > 0) {
                        left += dp[i][j - 1];
                    } else {
                        left += (int) Math.pow(10, 9);
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int minimumPathSumSpaceOptimization(int mat[][], int m, int n) {
        int prev[] = new int[n];
        for (int i = 0; i < m; i++) {
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = mat[i][j];
                } else { 
                    int up = mat[i][j];
                    if (i > 0) {
                        up += prev[j];
                    } else {
                        up += (int) Math.pow(10, 9);
                    }
                    int left = mat[i][j];
                    if (j > 0) {
                        left += temp[j - 1];
                    } else {
                        left += (int) Math.pow(10, 9);
                    }
                    temp[j] = Math.min(up, left);
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }

    public static void main(String[] args) {
        int mat[][] = { { 10, 8, 2 }, { 10, 5, 100 }, { 1, 1, 2 } };
        int m = 3;
        int n = 3;
        System.out.println(minimumPathSumRecurssion(mat, m - 1, n - 1));
        int dp[][] = new int[m][n];
        for (int I = 0; I < m; I++) {
            for (int J = 0; J < n; J++) {
                dp[I][J] = -1;
            }
        }
        System.out.println(minimumPathSumMemo(mat, m - 1, n - 1, dp));
        System.out.println(minimumPathSumTabulation(mat, m, n));
        System.out.println(minimumPathSumSpaceOptimization(mat, m, n));

    }
}
