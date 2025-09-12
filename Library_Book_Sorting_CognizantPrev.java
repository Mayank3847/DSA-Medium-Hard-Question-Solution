import java.util.*;

public class Library_Book_Sorting_CognizantPrev {
    public static int libraryBookSorting(int n, String s) {
        char original[] = s.toCharArray();
        char sort[] = s.toCharArray();
        int cnt = 0;
        Arrays.sort(sort);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != sort[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 5;
        String s = "ehlco";
        System.out.println(libraryBookSorting(n, s));
    }
}
