public class Pen_Switching_Problem {

    public static int penSwitching(int arr[], int N) {
        int switches = 0;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 == 0) {
                switches++;
            }
        }
        return switches;
    }

    public static void main(String[] args) {
        int arr[] = { 70, 23, 13, 26, 72, 19 };
        int arr1[] = { 1, 2, 1, 6, 10, 9 };
        int n = 6;
        System.out.println(penSwitching(arr, n));
        System.out.println(penSwitching(arr1, n));

    }
}
