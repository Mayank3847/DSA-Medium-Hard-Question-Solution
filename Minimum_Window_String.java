import java.util.*;

public class Minimum_Window_String {
    public static String minimumWindowStringBruteForce(String s, String t) {
        int n = s.length();
        int minLength = Integer.MAX_VALUE;
        String minString = "";

        Map<Character, Integer> tFreq = new HashMap<>();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < tArr.length; i++) {
            char tCh = tArr[i];
            tFreq.put(tCh, tFreq.getOrDefault(tCh, 0) + 1);

        }
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> windowFreq = new HashMap<>();
            for (int j = i; j < n; j++) {
                char sCh = s.charAt(j);
                windowFreq.put(sCh, windowFreq.getOrDefault(sCh, 0) + 1);

                if (containsAll(windowFreq, tFreq)) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        minString = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return minString;
    }

    public static boolean containsAll(Map<Character, Integer> sFreq, Map<Character, Integer> tFreq) {
        ArrayList<Character> list = new ArrayList<>(tFreq.keySet());
        for (int i = 0; i < list.size(); i++) {
            char fCh = list.get(i);
            if (sFreq.getOrDefault(fCh, 0) < tFreq.get(fCh)) {
                return false;
            }
        }
        return true;
    }

    public static String minimumWindowStringOptimal(String s, String t) {
        int hash[] = new int[256];
        for (char ch : t.toCharArray()) {
            hash[ch]++;

        }
        int left = 0;
        int sIndex = -1;
        int min_Val = Integer.MAX_VALUE;
        int cnt = 0;
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            hash[rChar]--;
            if (hash[rChar] >= 0) {
                cnt++;
            }
            while (cnt == t.length()) {
                if (right - left + 1 < min_Val) {

                    min_Val = right - left + 1;
                    sIndex = left;
                }
                char lChar = s.charAt(left);
                hash[lChar]++;
                if (hash[lChar] > 0) {
                    cnt--;
                }
                left++;

            }
        }
        if (sIndex == -1) {
            return "";
        } else {
            return s.substring(sIndex, sIndex + min_Val);
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowStringBruteForce(s, t));
        System.out.println(minimumWindowStringOptimal(s, t));

    }

}
