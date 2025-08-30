public class DP_Count_Subset_With_Sum_K {

    public static int subsetSumWithKRec(int arr[], int target) {
        return solve(arr, arr.length - 1, target);
    }

    public static int solve(int arr[], int idx, int target) {
        if (target == 0) {
            return 1;
        }
        if (idx == 0) {
            // return arr[0]=target?1:0;
            if (arr[0] == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int notPick = solve(arr, idx - 1, target);
        int pick = 0;
        if (arr[idx] <= target) {
            pick = solve(arr, idx - 1, target - arr[idx]);
        }
        return pick + notPick;
    }

    public static int subsetSumWithKMemo(int arr[], int target) {
        int dp[][] = new int[arr.length][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMemo(arr, arr.length - 1, target, dp);
    }

    public static int solveMemo(int arr[], int idx, int target, int dp[][]) {
        if (target == 0) {
            return 1;
        }
        if (idx == 0) {
            // return arr[0]=target?1:0;
            if (arr[0] == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int notPick = solveMemo(arr, idx - 1, target,dp);
        int pick = 0;
        if (arr[idx] <= target) {
            pick = solveMemo(arr, idx - 1, target - arr[idx],dp);
        }
        return dp[idx][target] = pick + notPick;
    }

    public static int subsetSumWithKTabulation(int arr[], int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    } 


    
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3 };
        int target = 3;
        System.out.println(subsetSumWithKRec(arr, target));
        System.out.println(subsetSumWithKMemo(arr, target));
        System.out.println(subsetSumWithKTabulation(arr, target));

    }
}
