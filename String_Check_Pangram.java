public class String_Check_Pangram {
    public static boolean checkPangram(String s) {
        // code here
        int n = s.length();
        boolean[] freq = new boolean[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                freq[ch - 'A'] = true;
            else if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!freq[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "The quick brown fox jump over the lazy dog";
        System.out.println(checkPangram(s));
    }

}
