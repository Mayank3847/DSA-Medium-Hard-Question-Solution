public class Library_Collections_Book_CognizantPrev {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int libraryCollections(int n, int k, int book[]) {
        int bookStore = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                if (book[i - 1] > k) {
                    bookStore += k;
                } else {

                    bookStore += book[i - 1];
                }
            }
        }
        return bookStore;
    }

    public static void main(String[] args) {
        int books[] = { 3, 7, 5, 6 };
        int n = 4;
        int k = 5;
        System.out.println(libraryCollections(n, k, books));
        int[] books3 = { 5, 6, 10, 8, 15 };
        int n3 = 5;
        int k3 = 7;
        System.out.println(libraryCollections(n3, k3, books3));
    }

}
