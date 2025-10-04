public class Capegemini_Compress_String {
    public static String compressString(String s) {
        int n = s.length();
        int left = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(left)) {
                int count = i - left;
                result.append(s.charAt(left));
                if (count >= 1) {
                    result.append(count);

                }
                left = i;
            } else if (i == n - 1) {
                int count = i - left + 1;
                result.append(s.charAt(left));
                if (count >= 1) {
                    result.append(count);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aabbbbeeeeffggg";
        System.out.println(compressString(s));
    }
}
