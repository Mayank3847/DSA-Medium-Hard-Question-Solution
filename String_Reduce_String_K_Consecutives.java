import java.util.*;

public class String_Reduce_String_K_Consecutives {

    static    class Pair {
        char ch;
        int cnt;

        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;

        }
    }

    public static String removeKChar(int k, String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            st.push(ch);
            int count = 0;
            while (!st.isEmpty() && st.peek() == ch) {
                count++;
                st.pop();
            }
            if (count == k)
                continue;
            else {
                while (count > 0) {
                    st.push(ch);
                    count--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        return result.toString();
    }

    public static String removeKCharOptimized(int k, String s) {
        Stack<Pair> st = new Stack<>();
        if (k == 1)
            return "";
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            if (!st.isEmpty() && st.peek().ch == ch1) {
                st.peek().cnt++;

                if (st.peek().cnt == k) {
                    st.pop();
                }

            } else {
                st.push(new Pair(ch1, 1));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            Pair p = st.get(i);
            for (int j = 0; j < p.cnt; j++) {
                result.append(p.ch);
            }
        }
        return result.toString();

    }

    public static void main(String[] args) {
        int k = 3;
        String s = "abbbaaa";
        String ans = removeKChar(k, s);
        System.out.println(ans);
        System.out.println(removeKCharOptimized(k, s));
    }
}
