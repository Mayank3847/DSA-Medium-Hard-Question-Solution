public class String_MaxNumber_Of_Vowels_in_Substring {

    public static int maxVowels(String s, int k) {
        int n = s.length();
        int maxCnt = 0;
        for (int i = 0; i < n - k; i++) {
            int cnt = 0;
            for (int j = i; j < i + k; j++) {
                char ch = s.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    cnt++;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

    public static int maxVowelsOptimized(String s, int k) {
        int maxCnt = 0;
        int currCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                currCnt++;
            }
            if (i >= k) {
                char todelete = s.charAt(i - k);
                if (todelete == 'a' || todelete == 'e' || todelete == 'i' || todelete == 'o' || todelete == 'u') {
                    currCnt--;
                }
            }
            maxCnt = Math.max(currCnt, maxCnt);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
        System.out.println(maxVowelsOptimized(s, k));
        ;
    }
}