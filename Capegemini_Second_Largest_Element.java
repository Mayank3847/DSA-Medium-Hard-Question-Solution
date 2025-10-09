import java.util.PriorityQueue;

public class Capegemini_Second_Largest_Element {
    public static int secondLargest(int arr[]) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
        int first = Math.max(arr[0], arr[1]);
        int second = Math.min(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];

            } else if (arr[i] > second && arr[i] < first) {
                second = arr[i];
            }
        }
        if (first == second) {
            throw new RuntimeException("No second largest element found (all elements may be equal).");
        }
        return second;

    }

    public static int kthLargest(int arr[], int k) {
        if (arr.length < k) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 15, 10, 18, 9, 20, 5, 25, 3, 28 };
        System.out.println(secondLargest(arr));
        System.out.println(kthLargest(arr, 3));
    }

}
