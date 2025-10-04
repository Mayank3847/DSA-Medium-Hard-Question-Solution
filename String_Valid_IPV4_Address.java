import java.util.StringTokenizer;

public class String_Valid_IPV4_Address {
    public static boolean isValidIP(String s) {
        int n = s.length();
        if (n < 7)
            return false;
        StringTokenizer st = new StringTokenizer(s, ".");
        int count = 0;
        while (st.hasMoreTokens()) {
            String substr = st.nextToken();
            count++;
            if (substr.length() > 1 && substr.charAt(0) == '0')
                return false;
            for (int j = 0; j < substr.length(); j++) {
                if (!Character.isDigit(substr.charAt(j)))
                    return false;

            }
            if (Integer.parseInt(substr) > 255)
                return false;

        }
        if (count != 4)
            return false;
        return true;
    }

    public static boolean isValidIPOpti(String s) {
        int n = s.length();
        int num = -1;
        int count = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '.') {
                if (num == -1)
                    return false;
                num = -1;
                len = 0;
                count++;
            } else if (Character.isDigit(ch)) {
                if (num == -1) {
                    num = 0;
                    len = 0;
                }
                if (len == 0 && ch == '0' && ((i + 1) > n && s.charAt(i + 1) != '.')) {
                    return false;
                }
                num = num * 10 + (ch - '0');
                len++;
                if (num > 255) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (num == -1)
            return false;
        count++;

        return count == 4;
    }

    public static void main(String[] args) {
        String s = "123.125.12.1";
        System.out.println(isValidIP(s));
        System.out.println(isValidIPOpti(s));
    }

}
