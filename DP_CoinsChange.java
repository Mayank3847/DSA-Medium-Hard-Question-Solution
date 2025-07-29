import java.util.*;
public class DP_CoinsChange {
    public static int coinChange(int coins[], int amount) {
        int result = coinChangeRecurssive(coins, amount, 0);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    public static int coinChangeRecurssive(int coins[], int amount, int index) {
        if (amount == 0)
            return 0;
        if (index >= coins.length || amount < 0) {
            return Integer.MAX_VALUE; 
        }
        int include = coinChangeRecurssive(coins, amount - coins[index], index);
        if (include != Integer.MAX_VALUE) {
            include += 1;
        }
        int exclude = coinChangeRecurssive(coins, amount, index + 1);
        return Math.min(include, exclude);
    }


    //By DP-Tabulation
     public static  int coinChange_DP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  
        dp[0] = 0;                  
        for (int i = 1; i <= amount; i++) {   
            for (int coin : coins) {          
                if (coin <= i) {            
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);  
                                                                 
                }
            }
        }

        return (dp[amount] > amount) ? -1 : dp[amount]; 
    }


    //By memoization
    public static int coinChangeMemoization(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = helper(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] coins, int rem, int[] memo) {
        if (rem < 0) return Integer.MAX_VALUE; 
        if (rem == 0) return 0; 
        if (memo[rem] != -1) return memo[rem]; 
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, memo);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1); 
            }
        }

        memo[rem] = min;
        return memo[rem];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange_DP(coins, amount));
        System.out.println(coinChangeMemoization(coins, amount));

    }

}
