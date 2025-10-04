public class String_Add_Binary_Strings {
      static String trimLeadingZeros(String s) {

        int firstOne = s.indexOf('1');
        return (firstOne == -1) ? "0"
                                : s.substring(firstOne);
    }
    public static String addBinary(String s1, String s2) {
         s1 = trimLeadingZeros(s1);
        s2 = trimLeadingZeros(s2);
          int n=s1.length();
        int m = s2.length();
        int i=n-1;
        int j =m-1;
        int carry=0;
        StringBuilder result=new StringBuilder();
        while(i>=0||j>=0||carry>0){
            int sum=carry;
            if(i>=0){
                sum+=s1.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum+=s2.charAt(j)-'0';
                j--;
            }
            result.append(sum%2);
            carry=sum/2;
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        String s1="1101";
        String s2="111";
        System.out.println( addBinary(s1, s2));
    }

}
