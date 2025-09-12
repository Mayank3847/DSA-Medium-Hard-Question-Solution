import java.util.*;

public class MinimumSum_CognizantPrev {
    public static int minimumSum(Integer A[], Integer B[], int n) {
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] A = { 1, 4, 3, 2 };
        Integer[] B = { 1, 4, 3, 4 };
        int n = 4;
        System.out.println(minimumSum(A, B, n));
    }

}
