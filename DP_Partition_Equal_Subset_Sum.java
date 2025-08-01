public class DP_Partition_Equal_Subset_Sum {
    public static boolean partitionEqualSubsetRecurssion(int nums[]) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];

        }
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        return partition(nums, 0, target);
    }

    public static boolean partition(int nums[], int idx, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || idx >= nums.length) {
            return false;
        }
        return partition(nums, idx + 1, target - nums[idx]) || partition(nums, idx + 1, target);
    }

    // By DP
    public static boolean partitionEqualSubsetDP(int nums[]) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];

        }
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int number = nums[i];
            for (int j = target; j >= number; j--) {
                dp[j] = dp[j] || dp[j - number];
            }

        } 
        return dp[target];
    }

    public static void main(String[] args) {
        int nums[] = { 5, 11, 5,1};
        System.out.println(partitionEqualSubsetRecurssion(nums));
        System.out.println(partitionEqualSubsetDP(nums));

    }

}
