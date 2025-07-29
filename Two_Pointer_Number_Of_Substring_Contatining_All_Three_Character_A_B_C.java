public class Two_Pointer_Number_Of_Substring_Contatining_All_Three_Character_A_B_C {
    public static int substringAllCharacterBruteForce(String str) {
        int n = str.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean hasA = false, hasB = false, hasC = false;
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);
                if (ch == 'a') {
                    hasA = true;
                } else if (ch == 'b') {
                    hasB = true;
                } else if (ch == 'c') {
                    hasC = true;
                }
                if (hasA && hasB && hasC) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int substringAllCharacterOptimal(String s) {
        int n = s.length();
        int count[] = new int[3];
        int result = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(left) - 'a']--;
                result += n - i;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        System.out.println(substringAllCharacterBruteForce(str));
        System.out.println(substringAllCharacterOptimal(str));
    }

}
