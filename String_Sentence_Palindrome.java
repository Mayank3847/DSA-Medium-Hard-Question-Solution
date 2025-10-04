public class String_Sentence_Palindrome {
    public static boolean palindromeSenternce(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(i)) {
                i++;
            } else if (!Character.isLetterOrDigit(j)) {
                j--;
            } else if (Character.toLowerCase(i) == Character.toLowerCase(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
 public static boolean isPalinSent(String s) {
        // code here
        StringBuilder sb=new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder rev=new StringBuilder(sb.toString());
        rev.reverse();
        return sb.toString().equals(rev.toString());
        
    }
    public static void main(String[] args) {
        String s = "Too hot to hoot.";
        System.out.println(palindromeSenternce(s));
    }

}
