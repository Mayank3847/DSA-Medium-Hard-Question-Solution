public class DP_3D_Ninja_And_His_Friend_MaximumChocolate {
    public static int maxmChocolateRecurssion(int grid[][]) {
        // int n = grid.length;
        int m = grid[0].length;
        return helperRecurssion(0, 0, m - 1, grid);
    }

    public static int helperRecurssion(int row, int col1, int col2, int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return (int) Math.pow(10, -9);
        }
        if (row == n - 1) {

            if (col1 != col2) {
                return grid[row][col1] + grid[row][col2];
            } else {
                return grid[row][col1];// as we can take col2 as well because if both are same then we can take any one
                                       // of them
            }
        }
        int maxChoco = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextCol1 = i + col1;
                int nextCol2 = j + col2;
                int value;
                if (col1 == col2) {
                    value = grid[row][col1];
                } else {
                    value = grid[row][col2] + grid[row][col1];
                }

                value += helperRecurssion(row + 1, nextCol1, nextCol2, grid);
                maxChoco = Math.max(value, maxChoco);
            }
        }
        return maxChoco;
    }

    public static int maxmChocolateMemo(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helperMemo(0, 0, m - 1, grid, dp);
    }

    public static int helperMemo(int row, int col1, int col2, int grid[][], int dp[][][]) {
        int n = grid.length;
        int m = grid[0].length;
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return (int) Math.pow(10, -9);
        }
        if (row == n - 1) {

            if (col1 != col2) {
                return grid[row][col1] + grid[row][col2];
            } else {
                return grid[row][col1];// as we can take col2 as well because if both are same then we can take any one
                                       // of them
            }
        }
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int maxChoco = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextCol1 = i + col1;
                int nextCol2 = j + col2;
                int value;
                if (col1 == col2) {
                    value = grid[row][col1];
                } else {
                    value = grid[row][col2] + grid[row][col1];
                }

                value += helperRecurssion(row + 1, nextCol1, nextCol2, grid);
                maxChoco = Math.max(value, maxChoco);
            }
        }
        return dp[row][col1][col2] = maxChoco;
    }

    public static int maxmChocolateTabulation(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                } else {
                    dp[n - 1][j1][j2] = grid[n - 1][j2] + grid[n - 1][j1];
                }  
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2) {
                                ans = grid[i][j1];

                            } else {
                                ans = grid[i][j1] + grid[i][j2];
                            }

                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m)) {
                                ans += (int) Math.pow(-10, 9);
                            } else {
                                ans += dp[i + 1][j1 + di][j2 + dj];
                            }
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];
    }


    
    public static void main(String[] args) {
        int[][] grid = {
                { 3, 1, 1 },
                { 2, 5, 1 },
                { 1, 5, 5 },
                { 2, 1, 1 }
        };
        System.out.println(maxmChocolateRecurssion(grid));
        System.out.println(maxmChocolateMemo(grid));
        System.out.println(maxmChocolateTabulation(grid));

    }
}