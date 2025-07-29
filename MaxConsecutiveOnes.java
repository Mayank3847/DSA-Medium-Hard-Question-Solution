public class MaxConsecutiveOnes {
    public static int maxConsectiveOnesBruteForce(int arr[], int k) {
        int n = arr.length;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int zeroCnt = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    zeroCnt++;
                }
                if (zeroCnt > k) {
                    break;
                }
                maxLen = Math.max(maxLen, j - i + 1);

            }
        }
        return maxLen;
    }

    public static int maxConsectiveOnesOptimal(int arr[], int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int zeroCnt = 0;
        while (right < arr.length) {
            if (arr[right] == 0) {
                zeroCnt++;
            }
            while (zeroCnt > k) {
                if (arr[left] == 0) {
                    zeroCnt--;
                }
                left++;

            }
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(maxConsectiveOnesBruteForce(arr, k));
        System.out.println(maxConsectiveOnesOptimal(arr, k));

    }

}
