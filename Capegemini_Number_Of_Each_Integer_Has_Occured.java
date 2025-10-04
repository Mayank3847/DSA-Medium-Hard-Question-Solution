import java.util.*;

public class Capegemini_Number_Of_Each_Integer_Has_Occured {
    public static void numberPrint(int arr[]) {
        Arrays.sort(arr);
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[left] != arr[i]) {
                int count = i - left;
                if (count >= 1) {
                    System.out.println(arr[left] + " occured at " + count + " Times ");
                }
                left = i;
            }
            if (i == arr.length - 1) {
                int count = i - left + 1;
                System.out.println(arr[left] + " occured at " + count + " Times ");
            }

        }
    }

    public static void numberPrintHashMap(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            System.out.println(key + " Occurs " + map.get(key) + " times.");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 4, 1, 4, 5, 1, 2 };
        numberPrint(arr);
        System.out.println("By Hash Map");
        numberPrintHashMap(arr);
    }
}
