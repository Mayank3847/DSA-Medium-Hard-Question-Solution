public class CountNumber_NiceSubarrays {

    public static int niceSubarrays(int nums[], int k) {

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int oddCnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 != 0) {
                    oddCnt++;
                }
                if (oddCnt == k) {
                    cnt++;
                } else if (oddCnt > k) {
                    break;
                }

            }
        }
        return cnt;
    }

    public static int niceSubarraysOptimized(int nums[], int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    public static int countAtMost(int nums[], int k) {
        int left = 0, cnt = 0, oddCnt = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                oddCnt++;
            }
            while (oddCnt > k) {
                if (nums[left] % 2 != 0) {
                    oddCnt--;
                }
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // int nums[] = { 1, 1, 2, 1, 1 };
        int nums[] = {2, 2, 1, 2, 2, 1, 2, 2, 1}, k = 3;

        // int k = 3;
        // int nums1
        System.out.println(niceSubarrays(nums, k));
        System.out.println(niceSubarraysOptimized(nums, k));

    }
}