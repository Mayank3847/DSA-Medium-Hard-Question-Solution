import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String_K_Anagrams {
    public static boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;
        List<Character> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            char ch = keys.get(i);
            count += map.get(ch);
        }
        if (count > k) {
            return false;
        } else {
            return true;
        }
    }

    public static int areKAnagramsCount(String s1, String s2) {
        // if (s1.length() != s2.length())
        // return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;
        List<Character> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            char ch = keys.get(i);
            count += map.get(ch);
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "grammar";
        int k = 3;
        System.out.println(areKAnagrams(s1, s2, k));
        System.out.println(areKAnagramsCount(s1, s2));
    }

}
