import java.util.*;

public class Longest_Substring_Without_Repeating {
    public static int longestSubstringBruteForce(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int maxAns = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(s.charAt(j))) {
                    maxAns = Math.max(maxAns, j - i);
                    break;
                }
                set.add(s.charAt(j));
            }
        }
        return maxAns;
    }

    public static int longestSubstringOptimal1(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < n; right++) {
            if (set.contains(s.charAt(right))) {
                while (left < right && set.contains(s.charAt(right))) {
                    left++;
                    set.remove((s.charAt(right)));
                }

            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }

    public static int longestSubstringOptimal2(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;
        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "abcaabcbb";
        String s1 = "bbbbbb";
        System.out.println(longestSubstringBruteForce(s));
        System.out.println(longestSubstringBruteForce(s1));
        System.out.println(longestSubstringOptimal1(s));

        System.out.println(longestSubstringOptimal1(s1));
          System.out.println(longestSubstringOptimal2(s));

        System.out.println(longestSubstringOptimal2(s1));
    }
}
