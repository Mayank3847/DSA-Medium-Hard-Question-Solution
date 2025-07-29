import java.util.Arrays;

public class DP_Frog_Jump_With_K_Distance {
    public static int frogJumKDistanceRecurssion(int n, int ht[], int k) {
        return helper(n - 1, ht, k);
    }

    public static int helper(int idx, int ht[], int k) {
        if (idx == 0)
            return 0;
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = helper(idx - i, ht, k) + Math.abs(ht[idx] - ht[idx - i]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }
        return minEnergy;
    }

    // Memoization
    public static int frogJumKDistanceMemo(int n, int ht[], int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helperMemo(n - 1, ht, k, dp);
    }

    public static int helperMemo(int idx, int ht[], int k, int dp[]) {
        if (idx == 0)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = helperMemo(idx - i, ht, k, dp) + Math.abs(ht[idx] - ht[idx - i]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }
        return minEnergy;
    }

    // By DP--Tabulatiion         

    public static int frogJumKDistanceTabulation(int n, int ht[], int k) {
        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(ht[i] - ht[i - j]);
                    minEnergy = Math.min(minEnergy, jump);
                }

            }
            dp[i] = minEnergy;

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        System.out.println(frogJumKDistanceRecurssion(n, height, k));
        System.out.println(frogJumKDistanceMemo(n, height, k));
        System.out.println(frogJumKDistanceTabulation(n, height, k));

    }

}
