public class Chocolate_Distribution_CognizantPrev {
    static final int MOD = 1000000007;

    public static int chocolateDistribution(int N) {
        long total = 0;
        for (int i = 1; i <= N; i++) {
            int choco = i;
            int prev = (i - 2 + N) % N + 1;
            int next = (i % N) + 1;
            if (prev % 5 == 0 || next % 5 == 0) {
                choco += 2;
            }
            total = (total + choco) % MOD;
        }
        return (int) total;
    }

    public static void main(String[] args) {
        System.out.println(chocolateDistribution(5)); // Output: 19
        System.out.println(chocolateDistribution(3)); // Output: 6
        System.out.println(chocolateDistribution(10)); // Try for more
    }

}
