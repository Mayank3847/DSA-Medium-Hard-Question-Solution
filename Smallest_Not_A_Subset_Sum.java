
import java.util.*;

public class Smallest_Not_A_Subset_Sum {

    public static int notASubseSum(int arr[]) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = sum - arr[i]; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + arr[i]] = true;
                }
            }
        }
        for (int i = 0; i <= sum; i++) {
            if (!dp[i])
                return i;
        }
        return sum + 1;
    }

    public static int notASubseSumOptimized(int arr[]) {
        Arrays.sort(arr);
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= res) {
                res += arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 10, 3, 11, 6, 15 };
        System.out.println(notASubseSum(arr));
        System.out.println(notASubseSumOptimized(arr));
    }
}