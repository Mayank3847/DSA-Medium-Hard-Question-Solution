public class Minimum_Sum_Path_Triangle {

    public static int minimumSumPathTriangleRec(int triangle[][], int n) {
        return helper(0, 0, triangle, n);
    }

    public static int helper(int i, int j, int triangle[][], int n) {
        if (i == n - 1) {
            return triangle[i][j];
        }
        int down = triangle[i][j] + helper(i + 1, j, triangle, n);
        int diagonal = triangle[i][j] + helper(i + 1, j + 1, triangle, n);
        return Math.min(down, diagonal);

    }

    public static int minimumSumPathTriangleMemo(int triangle[][], int n) {
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helperMemo(0, 0, triangle, n, dp);
    }

    public static int helperMemo(int i, int j, int triangle[][], int n, int dp[][]) {
        if (i == n - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = triangle[i][j] + helperMemo(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + helperMemo(i + 1, j + 1, triangle, n, dp);
        return dp[i][j] = Math.min(down, diagonal);

    }

    public static int minimumSumPathTriangleTabulation(int triangle[][], int n) {
        int dp[][] = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    public static int minimumSumPathTriangleSpaceOptimization(int triangle[][], int n) {
        int prev[] = new int[n];
        int curr[] = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = triangle[n - 1][i];

        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + prev[j];
                int diagonal = triangle[i][j] + prev[j + 1];
                curr[j] = Math.min(down, diagonal);

            }
            prev = curr;
        }
        return prev[0];
    }

    public static void main(String[] args) {
        int triangle[][] = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };
        int n = triangle.length;
        System.out.println(minimumSumPathTriangleRec(triangle, n));
        System.out.println(minimumSumPathTriangleMemo(triangle, n));
        System.out.println(minimumSumPathTriangleTabulation(triangle, n));
        System.out.println(minimumSumPathTriangleSpaceOptimization(triangle, n));

    }
} 