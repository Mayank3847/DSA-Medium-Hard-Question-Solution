public class DP_Target_Sum {
    public static int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }

    public static int solve(int nums[], int currSum, int idx, int target) {
        if (idx == nums.length) {
            if (currSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int add = solve(nums, currSum + nums[idx], idx + 1, target);
        int sub = solve(nums, currSum - nums[idx], idx + 1, target);
        return add + sub;
    }

    public static int findTargetSumWaysMemo(int arr[], int target) {
        int totalSum = 0;
        for (int num : arr)
            totalSum += num;
        if (target > totalSum || target < -totalSum) {
            return 0;

        }
        int dp[][] = new int[arr.length][2 * totalSum + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMemo(arr, 0, 0, target, totalSum, dp);
    }

    public static int solveMemo(int arr[], int currSum, int idx, int target, int offSet, int dp[][]) {
        if (idx == arr.length) {
            if (currSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int shiftedSum = currSum + offSet;
        if (dp[idx][shiftedSum] != -1) {
            return dp[idx][shiftedSum];
        }
        int add = solveMemo(arr, currSum + arr[idx], idx + 1, target, offSet, dp);
        int sub = solveMemo(arr, currSum - arr[idx], idx + 1, target, offSet, dp);
        dp[idx][shiftedSum] = add + sub;
        return dp[idx][shiftedSum];

    }

    public static int findTargetSumWaysTabulation(int arr[], int target) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (totalSum < target || target < -totalSum) {
            return 0;
        }
        if ((target + totalSum) % 2 != 0)
            return 0;
        int subSetSum = (totalSum + target) / 2;
        return solveTab(arr, subSetSum);
    }

    public static int solveTab(int arr[], int sum) {
        int n = arr.length;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[n][sum];
    }

    public static int findTargetSumWaysSpaceOpti(int arr[], int target) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (totalSum < target || target < -totalSum) {
            return 0;
        }
        if ((target + totalSum) % 2 != 0)
            return 0;
        int subSetSum = (totalSum + target) / 2;
        return solveSpaaceOptim(arr, subSetSum);
    }

    public static int solveSpaaceOptim(int arr[], int sum) {
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1 };
        int target = 3;
        System.out.println(findTargetSumWays(arr, target));
        System.out.println(findTargetSumWaysMemo(arr, target));
        System.out.println(findTargetSumWaysTabulation(arr, target));
        System.out.println(findTargetSumWaysSpaceOpti(arr, target));

    }

}
