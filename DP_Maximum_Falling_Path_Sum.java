public class DP_Maximum_Falling_Path_Sum {
    public static int maximumFallingPathSumRec(int mat[][]) {
        int n = mat.length;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, helper(mat, 0, i));
        }
        return maxSum;
    }

    public static int helper(int mat[][], int i, int j) {
        int n = mat.length;
        if (j < 0 || j >= n) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1) {
            return mat[i][j];
        }
        int down = helper(mat, i + 1, j);
        int leftDiagonal = helper(mat, i + 1, j - 1);
        int rightDiagonal = helper(mat, i + 1, j + 1);
        return mat[i][j] + Math.max(down, Math.max(leftDiagonal, rightDiagonal));
    }

    public static int maximumFallingPathSumMemo(int mat[][]) {
        int n = mat.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, helperMemo(mat, 0, i, dp));
        }
        return maxSum;
    }

    public static int helperMemo(int mat[][], int i, int j, int dp[][]) {
        int n = mat.length;
        if (j < 0 || j >= n) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1) {
            return mat[i][j];
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int down = helperMemo(mat, i + 1, j, dp);
        int leftDiagonal = helperMemo(mat, i + 1, j - 1, dp);
        int rightDiagonal = helperMemo(mat, i + 1, j + 1, dp);
        return dp[i][j] = mat[i][j] + Math.max(down, Math.max(leftDiagonal, rightDiagonal));
    }

    public static int maximumFallingPathSumTabulation(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = mat[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int down = dp[i + 1][j];
                int leftDiagonal;
                if (j > 0) {
                    leftDiagonal = dp[i + 1][j - 1];

                } else {
                    leftDiagonal = Integer.MIN_VALUE;
                }
                int rightDiagonal;
                if (j < m - 1) {
                    rightDiagonal = dp[i + 1][j + 1];
                } else {
                    rightDiagonal = Integer.MIN_VALUE;
                }
                dp[i][j] = mat[i][j] + Math.max(down, Math.max(leftDiagonal, rightDiagonal));
            }

        }
        int maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxSum = Math.max(maxSum, dp[0][j]);
        }
        return maxSum;
    }

    public static int maximumFallingPathSumSpaceOptimization(int mat[][]) {
        int n = mat.length;
        int m = mat.length;
        int prev[] = new int[m];
        for (int i = 0; i < n; i++) {
            prev[i] = mat[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            int curr[] = new int[m];
            for (int j = 0; j < m; j++) {
                int down = prev[j];
                int leftDiagonal;
                if (j > 0) {
                    leftDiagonal = prev[j - 1];

                } else {
                    leftDiagonal = Integer.MIN_VALUE;
                }
                int rightDiagonal;
                if (j < n - 1) {
                    rightDiagonal = prev[j + 1];
                } else {
                    rightDiagonal = Integer.MIN_VALUE;
                }
                curr[j] = mat[i][j] + Math.max(down, Math.max(leftDiagonal, rightDiagonal));
            }
            prev = curr;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            maxSum = Math.max(maxSum, prev[i]);
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 2, 1, 3 },
                { 6, 5, 4 }, 
                { 7, 8, 9 }
        };
        System.out.println(maximumFallingPathSumRec(matrix));
        System.out.println(maximumFallingPathSumMemo(matrix));
        System.out.println(maximumFallingPathSumTabulation(matrix));
        System.out.println(maximumFallingPathSumSpaceOptimization(matrix));

    }
}
