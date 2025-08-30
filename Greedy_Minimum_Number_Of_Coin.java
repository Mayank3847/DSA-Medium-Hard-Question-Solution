import java.util.ArrayList;
import java.util.List;

public class Greedy_Minimum_Number_Of_Coin {
    public static List<Integer> minPartition(int N) {
        List<Integer> result = new ArrayList<>();
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int n = coins.length;

        for (int i = n - 1; i >= 0; i--) {
            while (N >= coins[i]) {
                N -= coins[i];
                result.add(coins[i]);

            }
        }

        return result;
    }

    public static int minNumberPartition(int N) {
        List<Integer> result = new ArrayList<>();
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int n = coins.length;

        for (int i = n - 1; i >= 0; i--) {
            while (N >= coins[i]) {
                N -= coins[i];
                result.add(coins[i]);

            }
        }

        return result.size();
    }

    public static void main(String[] args) {
        int V = 441;
        List<Integer> result = new ArrayList<>();
        result = minPartition(V);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+" ");
        }
        System.out.println();
        System.out.println("Minimum No. Of Coins requires to complete value of " + V + " : " + minNumberPartition(V));
    }
}
