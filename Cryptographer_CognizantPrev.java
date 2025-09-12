public class Cryptographer_CognizantPrev {
    public static String cryptographer(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                sb.append('z');
            } else {
                sb.append(alphabet.charAt(alphabet.indexOf(s.charAt(i)) - 1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "zdcea";
        System.out.println(cryptographer(s));
    }

}
