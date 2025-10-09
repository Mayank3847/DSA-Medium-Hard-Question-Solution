import java.util.Stack;

public class Capegemini_Balanced_Parenthesis {
    public static boolean balanceParenthesis(String str) {
        int n = str.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;
                if ((st.peek() == '(' && ch == ')') || (st.peek() == '[' && ch == ']')
                        || (st.peek() == '{' && ch == '}')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
public static void main(String[] args) {
    String s="(([{}]))";
    String s1="([{]})";
    System.out.println(balanceParenthesis(s));
    System.out.println(balanceParenthesis(s1));
    
}
}
