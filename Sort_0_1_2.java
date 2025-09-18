public class Sort_0_1_2 {
    public static void sort(int arr[]) {
        int n = arr.length;
        int c1 = 0, c2 = 0, c0 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                c0++;
            }
            if (arr[i] == 1)
                c1++;
            if (arr[i] == 2)
                c2++;
        }
        int idx = 0;
        for (int i = 0; i < c0; i++) {
            arr[idx] = 0;
            idx++;
        }
        for (int i = 0; i < c1; i++) {
            arr[idx] = 1;
            idx++;
        }
        for (int i = 0; i < c2; i++) {
            arr[idx] = 2;
            idx++;
        }

    }

    public static void sort012(int arr[]) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int tmp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = tmp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 0, 0, 1, 2, 2, 2, };
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort012(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
