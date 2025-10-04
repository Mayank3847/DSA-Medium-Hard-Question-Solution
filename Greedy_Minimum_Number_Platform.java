import java.util.*;

public class Greedy_Minimum_Number_Platform {
    public static int minimumNumberPlatform(int arr[], int dep[]) {
        int n = arr.length;
        int i = 1;
        int j = 0;
        int platform = 1;
        int result = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            } else if (arr[i] > dep[j]) {
                platform--;
                j++;
            }
            if (platform > result) {
                result = platform;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
        int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
        System.out.println("Minimum number of Platforms required " + minimumNumberPlatform(arr, dep));
    }

}
