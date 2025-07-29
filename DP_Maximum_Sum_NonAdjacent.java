import java.util.Arrays;


public class DP_Maximum_Sum_NonAdjacent {
    public static int maxSumNonAdjacentRecurssion(int arr[]) {
        int n = arr.length;
        return helper(arr, n - 1);
    }

    public static int helper(int arr[], int idx) {
        if (idx < 0) {
            return 0;
        }
        if (idx == 0) {
            return arr[idx];

        }
        // if(idx>1){
        int take = helper(arr, idx - 2) + arr[idx];
        int notTake = helper(arr, idx - 1);
        // }
        return Math.max(take, notTake);
    }

    // By memoization
    public static int maxSumNonAdjacentMemo(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return helperMemo(arr, n - 1, dp);
    }

    public static int helperMemo(int arr[], int idx, int dp[]) {
        if (idx == 0) {
            return arr[idx];

        }
        if (idx < 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int take = arr[idx] + helperMemo(arr, idx - 2, dp);
        int notTake = helperMemo(arr, idx - 1, dp);
        return dp[idx] = Math.max(take, notTake);
    }


    // By Tabulation
    public static int maxSumNonAdjacentTab(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int take = arr[i];
            if (i > 1) {
                take += dp[i - 2];
            }
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);

        }
        return dp[n - 1];
    }

    // By space optimization approach
    public static int maxSumNonAdjacentOptimized(int arr[]) {
        int n = arr.length;
        int currSum = arr[0];
        int prevSum = 0;
        for (int i = 1; i < n; i++) {
            int take = arr[i];
            if (i > 1) {
                take += prevSum;
            }
            int notTake = currSum;
            int currPosSum = Math.max(take, notTake);
            prevSum = currSum;
            currSum = currPosSum;

        }
        return currSum;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 9 };
        System.out.println(maxSumNonAdjacentRecurssion(arr));
        System.out.println(maxSumNonAdjacentMemo(arr));
        System.out.println(maxSumNonAdjacentTab(arr));
        System.out.println(maxSumNonAdjacentOptimized(arr));


    }

}
