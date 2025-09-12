public class Password_Distance_Problem_CognizantPrev {
    public static int passwordProblem(String s) {
        boolean allSame = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(0)) {
                allSame = false;
                break;
            }
        }
        if (allSame)
            return 0; 
        int maxLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(0)) {
                maxLength = Math.max(maxLength, i);
                break;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1)) {
                maxLength = Math.max(maxLength, s.length() - i - 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(passwordProblem("abc10")); // Output: 4
        System.out.println(passwordProblem("bbbb")); // Output: 0
        System.out.println(passwordProblem("a1a1a")); // Output: 3
        System.out.println(passwordProblem("z9x8y7")); // Output: 5
        System.out.println(passwordProblem("888888")); // Output: 0
    }

}
