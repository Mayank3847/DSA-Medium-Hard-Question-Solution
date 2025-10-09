import java.util.*;

public class Capegemini_Majority_Element {
    public static int majorityElement(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }

    public static List<Integer> majorityElementII(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static int majorityElementBoyerMoore(int arr[]) {
        int cnt = 0;
        int candidate = -1;
        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                candidate = arr[i];
                cnt++;
            } else {
                if (arr[i] == candidate) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;

            }
            if (count > arr.length / 2) {
                return candidate;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 3, 2, 3 };
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementII(arr));
        System.out.println(majorityElementBoyerMoore(arr));
    }
}
