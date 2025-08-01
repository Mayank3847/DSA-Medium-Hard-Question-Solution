public class DP_Partition_Set_Into_2_Subset {
    public static int partitionSet2Subset(int arr[]) {
        return helper(arr, 0, 0, 0);
    }

    public static int helper(int[] arr, int idx, int sum1, int sum2) {
        if (idx == arr.length) {
            return Math.abs(sum1 - sum2);
        }
        int diff1 = helper(arr, idx + 1, sum1 + arr[idx], sum2);
        int diff2 = helper(arr, idx + 1, sum1, sum2 + arr[idx]);
        return Math.min(diff1, diff2);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 3, 3, 4, 5 };
        // int arr1[] = { 3, 9, 7, 3 };
        System.out.println(partitionSet2Subset(arr));
    }
}
