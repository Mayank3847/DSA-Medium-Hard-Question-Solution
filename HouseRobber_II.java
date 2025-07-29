public class HouseRobber_II {
    public static int houseRobIIRecurssion(int nums[]) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int include = rob(nums, 0, n - 2);
        int exclude = rob(nums, 1, n - 1);
        return Math.max(include, exclude);
    }

    public static int rob(int nums[], int idx, int end) {
        if (idx > end) {
            return 0;
        }
        int include = nums[idx] + rob(nums, idx + 2, end);
        int exclude = rob(nums, idx + 1, end);
        return Math.max(include, exclude);

    }
    // by dp

    public static int houseRobIIDP(int nums[]) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];      
        }
        return Math.max(robDP(nums, 0, n - 2), robDP(nums, 1, n - 1));      
    }

    public static int robDP(int nums[], int start, int end) {

        if (start == end)
            return nums[start];
        int dp[] = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[start + i] + dp[i - 2]);

        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums3 = { 1, 3, 1, 3, 100 };
        int[] nums2 = { 1, 2, 3, 1 };
        int[] nums1 = { 2, 3, 2 };
        System.out.println(houseRobIIRecurssion(nums1));
        System.out.println(houseRobIIRecurssion(nums2));
        System.out.println(houseRobIIRecurssion(nums3));
        System.out.println(houseRobIIDP(nums1));
        System.out.println(houseRobIIDP(nums2));
        System.out.println(houseRobIIDP(nums3));

    }

}
