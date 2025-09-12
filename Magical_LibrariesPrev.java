public class Magical_LibrariesPrev {
    public static int magicalLibraries(int arr[][], int n, int m) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 != 0) {
                    sum += arr[i][j];
                }
                if (sum % 2 == 0 && sum != 0) {
                    cnt++;
                }
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(magicalLibraries(arr, n, m));
    }

}
