public class ReverseAnArray {
    public static void reverseAnArray(int numbers[]) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[right];
            numbers[right] = numbers[left];
            numbers[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        reverseAnArray(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
