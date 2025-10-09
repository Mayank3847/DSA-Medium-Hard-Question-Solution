import java.util.*;

public class Capegemini_Duplicates_Element {
    public static ArrayList<Integer> findDuplicates(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) == 2)
                list.add(arr[i]);
        }
        return list;

    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 7, 2, 1, 3, 4, 5, 6, 8, 9, 2, 2, 3, 4 };
        System.out.println(findDuplicates(arr));
    }
}
