import java.util.*;

public class Capegemini_Number_Of_Character_Appears_Twice {
    public static int numberOfCharacterTwice(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 2) {
                cnt++;
            } else if (map.get(ch) > 2) {
                cnt--;
            }
        }
        return cnt;
    }

    public static String stringOfCharacterTwice(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 2) {
                res.append(ch);
            } else if (map.get(ch) > 2) {
                int idx = res.indexOf(String.valueOf(ch));
                if (idx != -1) {
                    res.deleteCharAt(idx);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "programming";
        String s1 = "aaabbcc";
        System.out.println(numberOfCharacterTwice(s));
        System.out.println(stringOfCharacterTwice(s1));
    }

}
