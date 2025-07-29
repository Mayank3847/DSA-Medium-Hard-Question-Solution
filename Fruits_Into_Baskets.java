import java.util.*;

public class Fruits_Into_Baskets {
    public static int fruitsBaskets(int fruits[]) {
        int maxFrt = 0;
        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> fruitsType = new HashSet<>();
            int frts = 0;
            for (int j = i; j < fruits.length; j++) {
                fruitsType.add(fruits[j]);
                if (fruitsType.size() > 2) {
                    break;
                }
                frts++;
            }
            maxFrt = Math.max(maxFrt, frts);
        }
        return maxFrt;
    }

    public static int fruitsBasketOptimized(int fruits[]) {
        int maxFrts = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.  get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);

                }
                left++;
            }
            maxFrts = Math.max(maxFrts, right - left + 1);
        }
        return maxFrts;
    }

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 1, 2, 3 };
        System.out.println(fruitsBaskets(fruits));
        System.out.println(fruitsBasketOptimized(fruits));

    }

}
