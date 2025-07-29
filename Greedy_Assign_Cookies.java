import java.util.*;

public class Greedy_Assign_Cookies {

    public static int maxChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);

        int m = greed.length;
        int n = cookie.length;
        int i = 0;
        int cnt = 0;

        for (int j = 0; j < n; j++) {

            if (i < m && cookie[j] >= greed[i]) {
                cnt++;
                i++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int greed[] = { 1, 5, 3, 3, 4 };
        int cookie[] = { 4, 2, 1, 2, 1, 3 };
        System.out.println(maxChildren(greed, cookie));
    }
}