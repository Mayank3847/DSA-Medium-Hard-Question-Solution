public class Count_Subset_With_Given_Difference {
    static int MOD = (int) (Math.pow(10, 9) + 7);

    public static int countSubsetWithGivenDiffRecu(int arr[], int diff) {
        int n = arr.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];

        }
        if ((totalSum + diff) % 2 != 0 || diff > totalSum) {
            return 0;

        }
        int target = (totalSum + diff) / 2;
        return solve(arr, n - 1, target);

    }

    public static int solve(int arr[], int idx, int target) {

        if (idx == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            if (target == 0 || target == arr[0]) {
                return 1;
            }
            return 0;
        }
        int exclude = solve(arr, idx - 1, target);
        int include = 0;
        if (arr[idx] <= target) {
            include = solve(arr, idx - 1, target - arr[idx]);
        }
        return include + exclude;
    }

    public static int countSubsetWithGivenDiffMemo(int arr[], int diff) {
        int n = arr.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];

        }
        if ((totalSum + diff) % 2 != 0 || diff > totalSum) {
            return 0;

        }
        int target = (totalSum + diff) / 2;
        int dp[][] = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMemo(arr, n - 1, target, dp);

    }

    public static int solveMemo(int arr[], int idx, int target, int dp[][]) {

        if (idx == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            if (target == 0 || target == arr[0]) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int exclude = solveMemo(arr, idx - 1, target, dp);
        int include = 0;
        if (arr[idx] <= target) {
            include = solveMemo(arr, idx - 1, target - arr[idx], dp);
        }
        dp[idx][target] = include + exclude;
        return dp[idx][target];
    }

    public static int countSubsetWithGivenDiffTabulation(int arr[], int diff) {
        int n = arr.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];

        }
        if (totalSum - diff < 0 || (totalSum - diff) % 2 == 1)
            return 0;
        int target = (totalSum - diff) / 2;
        return solveTab(arr, target);

    }

    public static int solveTab(int arr[], int target) {
        int n = arr.length;
        int dp[][] = new int[n][target + 1];
        if (arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if (arr[0] != 0 && arr[0] < target)
            dp[0][arr[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTaken = dp[i - 1][j];
                int taken = 0;
                if (arr[i] <= j)
                    taken = dp[i - 1][j - arr[i]];
                dp[i][j] = (taken + notTaken) % MOD;

            }
        }
        return dp[n - 1][target];

    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 6, 4 };
        int diff = 3;
        int arr1[] = { 0, 0, 0, 1 };
        int diff1 = 1;
        System.out.println(countSubsetWithGivenDiffRecu(arr, diff));
        System.out.println(countSubsetWithGivenDiffMemo(arr, diff));
        System.out.println(countSubsetWithGivenDiffTabulation(arr, diff));

        System.out.println(countSubsetWithGivenDiffRecu(arr1, diff1));
        System.out.println(countSubsetWithGivenDiffMemo(arr1, diff1));
        System.out.println(countSubsetWithGivenDiffTabulation(arr1, diff1));

    }
}