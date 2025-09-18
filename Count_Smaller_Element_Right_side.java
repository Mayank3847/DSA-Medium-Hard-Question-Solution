import java.util.*;

public class Count_Smaller_Element_Right_side {
    public static class Pair {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void countSmallerRight(int arr[], int smallerCount[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            smallerCount[i] = 0;

        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    smallerCount[i]++;
                }
            }
        }

    }

    public static void printEle(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void countSmallerRightOpti(int arr[], int result[]) {
        int n = arr.length;
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(arr[i], i);
        }
        mergeSort(pair, 0, n - 1, result);
    }

    public static void mergeSort(Pair pairs[], int left, int right, int result[]) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(pairs, left, mid, result);
        mergeSort(pairs, mid + 1, right, result);
        merge(pairs, left, mid, right, result);

    }

    public static void merge(Pair[] pairs, int left, int mid, int right, int[] result) {
        int i = left;
        int j = mid + 1;
        int rightCount = 0;
        List<Pair> temp = new ArrayList<>();
        while (i <= mid && j <= right) {
            if (pairs[i].val <= pairs[j].val) {
                result[pairs[i].idx] += rightCount;
                temp.add(pairs[i++]);

            } else {
                rightCount++;
                temp.add(pairs[j++]);
            }
        }
        while (i <= mid) {
            result[pairs[i].idx] += rightCount;
            temp.add(pairs[i++]);

        }
        while (j <= right) {
            temp.add(pairs[j++]);

        }
        for (int k = left; k <= right; k++) {
            pairs[k] = temp.get(k - left);
        }

    }

    public static void main(String[] args) {
         int arr[] = {12, 1, 2, 3, 0, 11, 4};
        int n = arr.length;

        System.out.println("Brute Force Output:");
        int low1[] = new int[n];
        countSmallerRight(arr, low1);
        printEle(low1);

        System.out.println("Optimized Output:");
        int low2[] = new int[n];
        countSmallerRightOpti(arr, low2);
        printEle(low2);
    }

}
