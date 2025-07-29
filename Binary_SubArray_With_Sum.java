public class Binary_SubArray_With_Sum {
    public static int binarySubarray(int arr[], int goal) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == goal) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int binarySubarrayOptimized(int nums[], int goal) {
        return countWithMost(nums, goal) - countWithMost(nums, goal - 1);
    }

        public static int countWithMost(int arr[], int goal) {

            if (goal < 0)
                return 0;
            int left = 0;
            int sum = 0;
            int cnt = 0;
            for (int right = 0; right < arr.length; right++) {
                sum += arr[right];
                while (sum > goal) {
                    sum -= arr[left];
                    left++;
                }
                cnt += right - left + 1;
            }
            return cnt;

        }

    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(binarySubarray(arr, goal));
        System.out.println(binarySubarrayOptimized(arr, goal));
    }
}
