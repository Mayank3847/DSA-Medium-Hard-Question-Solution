public class DP_CoinsChangeII {
    public static int coinChangeRecurssion(int coins[], int target) {
        return abcd(coins, target, coins.length);
    }

    public static int abcd(int coins[], int target, int idx) {
        if (target == 0)
            return 1;
        if (target < 0|| idx==0) {
            return 0;
        }
        int include = abcd(coins, target - coins[idx - 1], idx);
        int exclude = abcd(coins, target, idx - 1);
        return include + exclude;
    }

    public static int CoinChangeDP(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int c = coins[i];
            for (int a = c; a <= amount; a++) {
                dp[a] += dp[a - c];
            }
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        int coins[] = { 1, 2 };
        int target = 4;
        System.out.println(coinChangeRecurssion(coins, target));
        System.out.println(CoinChangeDP(target,coins));

    }
}
