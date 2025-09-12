public class Bubble_Sort {

    public static void bubbleSort(int arr[]) {
        boolean swapped;
        int i, j;
        for (i = 0; i < arr.length; i++) {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }

    }

    public static void printEle(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 3, 1 };
        int n = 4;
        bubbleSort(arr);
        System.out.println("Sorted Array : ");
        printEle(arr, n);
    }
}