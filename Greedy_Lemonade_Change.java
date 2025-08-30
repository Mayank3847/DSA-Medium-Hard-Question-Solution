import java.util.HashMap;

public class Greedy_Lemonade_Change {

    public static boolean lemonadChangeBruteForce(int bills[]) {
        int n = bills.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        for (int i = 0; i < n; i++) {
            int bill = bills[i];
            if (bill == 5) {
                map.put(5, map.getOrDefault(bill, 0) + 1);
            } else if (bill == 10) {
                if (map.get(5) == 0) {
                    return false;
                }
                map.put(5, map.get(5) - 1);
                map.put(10, map.get(10) + 1);
            } else if (bill == 20) {
                if (map.get(5) > 0 && map.get(10) > 0) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);

                } else if (map.get(5) >= 3) {
                    map.put(5, map.get(5) - 3);

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean lemonadeChangeOptimal(int bills[]) {
        int n = bills.length;
        int five = 0;
        int ten = 0;
        for (int i = 0; i < n; i++) {
            int bill = bills[i];
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int bills[] = { 5, 5, 5, 10, 10, 20 };
        int bills1[] = { 5, 5, 10, 10, 20 };

        System.out.println(lemonadChangeBruteForce(bills));
        System.out.println(lemonadChangeBruteForce(bills1));
         System.out.println(lemonadeChangeOptimal(bills));
        System.out.println(lemonadeChangeOptimal(bills1));

    }

}
