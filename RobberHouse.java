public class RobberHouse {

    public static int robHouseRecurssion(int nums[]) {
        return robHouse(0, nums);
    }

    public static int robHouse(int idx, int nums[]) {
        if (idx >= nums.length) {
            return 0;
        }
        int robHse = nums[idx] + robHouse(idx + 2, nums);
        int skipHouse = robHouse(idx + 1, nums);
        return Math.max(skipHouse, robHse);

    }

    // By Dp
    public static int robHouseDP(int nums[]) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            int take = nums[i] + dp[i - 2]; 

            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] houses = { 2, 7, 9, 3, 1 };
        System.out.println(robHouseRecurssion(houses));
        System.out.println(robHouseDP(houses));

    }
}