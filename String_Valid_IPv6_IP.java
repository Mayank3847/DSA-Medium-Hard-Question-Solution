public class String_Valid_IPv6_IP {
    public static boolean isValidIPv6(String s) {
        if (s.length() < 15)
            return false;
        String parts[] = s.split(":");
        if (parts.length != 8)
            return false;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty() || part.length() > 4)
                return false;
            for (int j = 0; j < part.length(); j++) {
                char ch = part.charAt(j);
                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(isValidIPv6(s));
    }

}
