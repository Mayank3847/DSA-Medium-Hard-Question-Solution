
public class DP_Minimum_Coins {
    public static int minimumCoins(int coins[], int target) {
        int n = coins.length;
        int ans = solve(n - 1, coins, target);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public static int solve(int idx, int coins[], int target) {
        if (idx == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            } else {
                return (int) Math.pow(10, 9);
            }
        }
        int notTaken = 0 + solve(idx - 1, coins, target);
        int taken = (int) Math.pow(10, 9);
        if (coins[idx] <= target) {
            taken = 1 + solve(idx, coins, target - coins[idx]);
        }
        return Math.min(taken, notTaken);
    }

    public static int minimumCoinsMemo(int coins[], int target) {

        int n = coins.length;
        int dp[][] = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = -1;

            }
        }
        int ans = solveMemo(n - 1, coins, target, dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;

    }

    public static int solveMemo(int idx, int coins[], int target, int dp[][]) {
        if (idx == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            } else {
                return (int) Math.pow(10, 9);
            }
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int notTaken = 0 + solveMemo(idx - 1, coins, target, dp);
        int taken = (int) Math.pow(10, 9);
        if (coins[idx] <= target) {
            taken = 1 + solveMemo(idx, coins, target - coins[idx], dp);
        }
        return dp[idx][target] = Math.min(taken, notTaken);
    }

    public static int minimumCoinsSpaceOpti(int arr[], int target) {
        int n = arr.length;
        int prev[] = new int[target + 1];
        int curr[] = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0) {
                prev[i] = i / arr[0];
            } else {
                prev[i] = (int) Math.pow(10, 9);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTaken = 0 + prev[j];
                int taken = (int) Math.pow(10, 9);
                if (arr[i] <= j) {
                    taken = 1 + curr[j - arr[i]];
                }
                curr[j] = Math.min(notTaken, taken);

            }
            prev = curr;
        }
        int ans = prev[target];
        if (ans >= (int) Math.pow(10, 9)) {
            return -1;
        }
        return ans;
    }

    public static int minimumCoinsTab(int arr[], int target) {
        int n = arr.length;
        int dp[][] = new int[n][target + 1];
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            } else {
                dp[0][i] = (int) Math.pow(10, 9);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTaken = dp[i - 1][j];
                int taken = (int) Math.pow(10, 9);
                if (arr[i] <= j) {
                    taken = 1 + dp[i][j - arr[i]];
                }
                dp[i][j] = Math.min(notTaken, taken);
            }
        }
        int ans = dp[n - 1][target];
        if (ans >= (int) Math.pow(10, 9)) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
        int target = 6;
        System.out.println(minimumCoins(coins, target));
        System.out.println(minimumCoinsMemo(coins, target));
        System.out.println(minimumCoinsTab(coins, target));
        System.out.println(minimumCoinsSpaceOpti(coins, target));

    }
}
