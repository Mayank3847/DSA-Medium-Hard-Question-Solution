import java.util.Arrays;

public class Frog_Jump {

    // recurssion  
    public static int frogJumpRecurssion(int height[]) {
        return helper(height, height.length   - 1);
    }

    public static int helper(int height[], int idx) {
        if (idx == 0) {
            return 0;

        }
        int jump1 = helper(height, idx - 1) + Math.abs(height[idx] - height[idx - 1]);
        int jump2 = Integer.MAX_VALUE;
        if (idx > 1)
            jump2 = helper(height, idx - 2) + Math.abs(height[idx] - height[idx - 2]);
        return Math.min(jump1, jump2);
    }

    //Memoization
    public static int frogJumpMemo(int height[]) {
    int n = height.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);  
    return helper(height, n - 1, dp);
}

public static int helper(int[] height, int idx, int[] dp) {
    if (idx == 0) return 0;

    if (dp[idx] != -1) return dp[idx];

    int jump1 = helper(height, idx - 1, dp) + Math.abs(height[idx] - height[idx - 1]);

    int jump2 = Integer.MAX_VALUE;
    if (idx > 1) {
        jump2 = helper(height, idx - 2, dp) + Math.abs(height[idx] - height[idx - 2]);
    }

    return dp[idx] = Math.min(jump1, jump2);
}


//Optimized version 
public static int frogJumpOptimized(int[] height) {
    int n = height.length;

    int prev = 0;        
    int prev2 = 0;       

    for (int i = 1; i < n; i++) {
        int jump1 = prev + Math.abs(height[i] - height[i - 1]);
        int jump2 = Integer.MAX_VALUE;

        if (i >  1) {
            jump2 = prev2 + Math.abs(height[i] - height[i - 2]);
        }

        int curr = Math.min(jump1, jump2);
        prev2 = prev;
        prev = curr;
    }

    return prev; 
}


//DP
public static int frogJumpDP(int[] height) {
    int n = height.length;
    int[] dp = new int[n];
    
    dp[0] = 0; 

    for (int i = 1; i < n; i++) {
        int jump1 = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
        int jump2 = Integer.MAX_VALUE;

        if (i > 1) {
            jump2 = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
        }

        dp[i] = Math.min(jump1, jump2);
    }

    return dp[n - 1]; 
}
    public static void main(String[] args) {
        int[] height = { 10, 30, 40, 20 };
        System.out.println(frogJumpRecurssion(height));
        System.out.println(frogJumpMemo(height));
        System.out.println(frogJumpDP(height));


    }

}
