public class DP_SubsetSum_Equal_k {
    public static boolean subsetSumEqualK(int arr[], int target, int idx) {
        if (target == 0) {
            return true;
        }
        if (idx == arr.length) {
            return false;
        }
        boolean pick = false;
        if (arr[idx] <= target) {
            pick = subsetSumEqualK(arr, target - arr[idx], idx + 1);
        }
        boolean notPick = subsetSumEqualK(arr, target, idx + 1);
        return pick || notPick;
    }

    public static boolean subsetSumEqualKMemo(int arr[], int target) {
        int dp[][] = new int[arr.length][target + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(arr, target, 0, dp);
    }

    public static boolean helper(int arr[], int target, int idx, int dp[][]) {
        if (target == 0) {
            return true;
        }
        if (idx == arr.length || target < 0) {
            return false;
        }
        if (dp[idx][target] != -1) {

            return dp[idx][target] == 1;

        }
        boolean pick = false;
        if (arr[idx] <= target) {
            pick = helper(arr, target - arr[idx], idx + 1, dp);
        }
        boolean notPick = helper(arr, target, idx + 1, dp);

        if (pick || notPick) {
            dp[idx][target] = 1;
        } else {
            dp[idx][target] = 0;
        }
        return pick || notPick;

    }

    public static boolean subsetSumEqualKTabulation(int arr[], int target) {
         if (arr.length == 0) return target == 0;
        boolean dp[][] = new boolean[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (arr[i] <= j) {
                    pick = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = pick || notPick;
            }
        }
        return dp[arr.length - 1][target];
    }

    public static boolean subsetSumEqualKSpaceOptimization(int arr[], int target) {
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 3, 5 };
        int idx = 0;
        int target = 4;
        boolean result = subsetSumEqualK(arr, target, idx);
        System.out.println(result);

        boolean resultMemo = subsetSumEqualKMemo(arr, target);
        System.out.println(resultMemo);

        boolean resultTab = subsetSumEqualKTabulation(arr, target);
        System.out.println(resultTab);

        boolean resultSpaceOpti = subsetSumEqualKSpaceOptimization(arr, target);
        System.out.println(resultSpaceOpti);

    }

}
