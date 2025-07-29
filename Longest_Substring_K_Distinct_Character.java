import java.util.*;

public class Longest_Substring_K_Distinct_Character {
    public static int longestSubstringKDistinctBruteForce(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(s.charAt(j));
                if (set.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static int longestSubstringKDistinctOptimal(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);

        }
        if (map.size() < k) {
            return -1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aababbcaacc";
        int k = 2;
        System.out.println(longestSubstringKDistinctBruteForce(s, k));
        System.out.println(longestSubstringKDistinctOptimal(s, k));
    }
}
