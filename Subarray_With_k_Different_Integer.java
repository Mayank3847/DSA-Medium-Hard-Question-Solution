import java.util.HashMap;
import java.util.Map;

public class Subarray_With_k_Different_Integer {
    public static int subarrayDifferntIntegerBruteForce(int nums[], int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == k) {
                    cnt++;
                } else if (map.size() > k) {
                    break;
                }

            }
        }
        return cnt;
    }

    public static int subarrayDifferntIntegerOptimal(int nums[], int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);

    }

        public static int countAtMost(int nums[], int k) {
            int result = 0;
            int start = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                map.put(val, map.getOrDefault(val, 0) + 1);
                while (map.size() > k) {
                    map.put(nums[start], map.get(nums[start]) - 1);
                    if (map.get(nums[start]) == 0) {
                        map.remove(nums[start]);
                    }
                    start++;
                }
                result += i - start + 1;
            }
            return result;

        }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(subarrayDifferntIntegerBruteForce(nums, k));
        System.out.println(subarrayDifferntIntegerOptimal(nums, k));
    }
}
