public class DP_Minimum_Path_Sum {

    public static int minimumPathRecurssion(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        return minimumPath(grid, n - 1, m - 1);
    }

    public static int minimumPath(int grid[][], int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];

        }
        if (i == 0) {
            return grid[i][j] + minimumPath(grid, i, j - 1);

        }
        if (j == 0) {
            return grid[i][j] + minimumPath(grid, i - 1, j);

        }
        return grid[i][j] + Math.min(minimumPath(grid, i, j - 1), minimumPath(grid, i - 1, j));
    }

    // By Dp
    public static int minimumPathDP(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < n; i++) {  
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 2, 3 },
                { 4, 8, 2 },
                { 1, 5, 3 },
                { 2, 1, 1 }
        };
        System.out.println(minimumPathRecurssion(grid));
        System.out.println(minimumPathDP(grid));

    }

}
