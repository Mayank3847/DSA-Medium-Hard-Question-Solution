public class DP_Partition_Set_Into_2_Subset {
    public static int partitionSet2Subset(int arr[]) {
        return helper(arr, 0, 0, 0, 0, 0);
    }

    public static int helper(int[] arr, int idx, int sum1, int sum2, int count1, int count2) {
        if (idx == arr.length) {
            if (count1 == 0 || count2 == 0)
                return Integer.MAX_VALUE;
            return Math.abs(sum1 - sum2);
        }
        int diff1 = helper(arr, idx + 1, sum1 + arr[idx], sum2, count1 + 1, count2);
        int diff2 = helper(arr, idx + 1, sum1, sum2 + arr[idx], count1, count2 + 1);
        return Math.min(diff1, diff2);
    }

    public static int partitionSetIn2SubsetRec(int arr[], int n) {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];

        }
        int minDiff[] = { Integer.MAX_VALUE };
        solve(arr, 0, 0, totalSum, n, minDiff);
        return minDiff[0];
    }

    public static void solve(int arr[], int idx, int subsetSum, int totalSum, int n, int[] minDiff) {
        if (idx == n) {
            int diff = Math.abs((totalSum - subsetSum) - subsetSum);
            minDiff[0] = Math.min(minDiff[0], diff);
            return;
        }
        solve(arr, idx + 1, subsetSum + arr[idx], totalSum, n, minDiff);
        solve(arr, idx + 1, subsetSum, totalSum, n, minDiff);

    }

    public static int partitionSet2SubsetMemo(int arr[]) {
        int n = arr.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        int dp[][] = new int[n][totalSum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMemo(arr, 0, 0, totalSum, dp, n);

    }

    public static int solveMemo(int arr[], int idx, int subsetSum, int totalSum, int dp[][], int n) {
        if (idx == n) {
            int otherSubSum = totalSum - subsetSum;
            return Math.abs(otherSubSum - subsetSum);

        }
        if (dp[idx][subsetSum] != -1) {
            return dp[idx][subsetSum];
        }
        int include = solveMemo(arr, idx + 1, subsetSum + arr[idx], totalSum, dp, n);
        int exclude = solveMemo(arr, idx + 1, subsetSum, totalSum, dp, n);
        dp[idx][subsetSum] = Math.min(include, exclude);
        return dp[idx][subsetSum];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 3, 3, 4, 5 };
        int n = arr.length;

        // int arr1[] = { 3, 9, 7, 3 };
        System.out.println(partitionSet2Subset(arr));
        System.out.println(partitionSetIn2SubsetRec(arr, n));
        System.out.println(partitionSet2SubsetMemo(arr));

    }
}
