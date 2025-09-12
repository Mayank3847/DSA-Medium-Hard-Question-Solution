import java.util.*;

public class Alex_Reading_Problem_CognizantPrevv {

    public static int alexReadingProblem(int arr[], int hours, int n) {
        Arrays.sort(arr);
        int total = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (total + arr[i] <= hours) {
                total += arr[i];
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 3, 1 };
        int hours = 5;
        int n = arr.length;
        System.out.println(alexReadingProblem(arr, hours, n));

    }
}