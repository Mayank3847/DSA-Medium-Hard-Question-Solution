import java.util.*;

public class Greedy_Knapsack_Fractional {
    static class Item implements Comparable<Item> {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(other.ratio, this.ratio);
        }
    }

    public static double fractionalKnapsack(int W, int value[], int weight[]) {
        int n = value.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(value[i], weight[i]);

        }
        Arrays.sort(items);
        Double result = 0.0;
        for (int i = 0; i < n; i++) {
            if (W == 0) {
                break;

            }
            Item item = items[i];
            if (item.weight <= W) {
                result += item.value;
                W -= item.weight;

            } else {
                result += item.ratio * W;
                W = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int W = 50;

        double maxValue = fractionalKnapsack(W, values, weights);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}
