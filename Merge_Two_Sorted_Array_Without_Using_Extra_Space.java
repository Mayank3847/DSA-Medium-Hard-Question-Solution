public class Merge_Two_Sorted_Array_Without_Using_Extra_Space {
    public static void mergeWithoutUsingExtraSpace(int a[], int b[]) {
        for (int i = b.length - 1; i >= 0; i--) {
            if (a[a.length - 1] > b[i]) {
                int last = a[a.length - 1];
                int j = a.length - 2;
                while (j >= 0 && a[j] > b[i]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 9, 10, 15, 20 };
        int[] b = { 2, 3, 8, 13 };
        mergeWithoutUsingExtraSpace(a, b);
        for (int i = 0; i < a.length; i++) {
            int ele = a[i];
            System.out.print(ele + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            int ele = b[i];
            System.out.print(ele + " ");

        }

    }
}
