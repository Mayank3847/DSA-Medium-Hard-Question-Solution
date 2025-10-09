public class Capegemini_PigLatin_GoatLatin {

    public static String goatLatin(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char ch = word.charAt(0);
            StringBuilder sb = new StringBuilder();
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                sb.append(word);

            } else {
                sb.append(word.substring(1)).append(ch);
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            result.append(sb).append(" ");
        }
        return result.toString();
    }

    public static String pigLatin(String s) {
        StringBuilder result = new StringBuilder();
        char ch = s.charAt(0);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            result.append(s).append("by");
        } else {
            result.append(s.substring(1)).append(ch).append("ed");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "I Am Mayank Shekhar";
        String s1 = "Apple";
        String s2 = "Banana";
        System.out.println(goatLatin(s));
        System.out.println(pigLatin(s2));
        System.out.println(pigLatin(s1));

    }

}
