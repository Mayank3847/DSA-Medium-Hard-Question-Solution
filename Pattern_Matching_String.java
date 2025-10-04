public class Pattern_Matching_String {

    public static int follPatt(String s) {
        // Your code here
        int n = s.length();
        int i = 0;
        while (i < n) {
            int cntX = 0, cntY = 0;
            while (i < n && s.charAt(i) == 'x') {
                i++;
                cntX++;
            }
            while (i < n && s.charAt(i) == 'y') {
                i++;
                cntY++;
            }
            if (cntX != cntY || cntX == 0 || cntY == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "xxyyxy";
        System.out.println(follPatt(s));
    }
}