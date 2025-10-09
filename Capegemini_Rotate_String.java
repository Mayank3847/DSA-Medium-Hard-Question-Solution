public class Capegemini_Rotate_String {
    public static boolean rotateString(String s, String t) {
        if (s.length() != t.length())
            return false;
        String str = s + s;
        return str.contains(t);

    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "cdeba";
        System.out.println(rotateString(s, t));
    }
}
