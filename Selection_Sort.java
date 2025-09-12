public class Selection_Sort {
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public static void printEle(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        int n = arr.length;
        System.out.println("Original Array :- ");
        printEle(arr, n);

        System.out.println("Sorted Array :- ");
        selectionSort(arr);
        printEle(arr, n);

    }

}
