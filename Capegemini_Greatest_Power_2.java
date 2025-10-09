public class Capegemini_Greatest_Power_2 {
    public static long nthPosition(long n) {
        // code here
        long power = 1;
        while (power * 2 <= n) {
            power *= 2;
        }
        return power;
    }

    public static void main(String[] args) {
        int n = 24;
        System.out.println(nthPosition(n));
    }
}
