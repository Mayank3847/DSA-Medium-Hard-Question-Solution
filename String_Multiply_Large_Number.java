
public class String_Multiply_Large_Number {
    public static String mutiplyLarge(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int i1 = 0, i2 = 0;
        int result[] = new int[n1 + n2];
        if (n1 == 0)
            return "0";
        if (n2 == 0)
            return "0";
        int nn = 1, mm = 1;
        if (s1.charAt(0) == '-')
            nn = -1;
        if (s2.charAt(0) == '-')
            mm = -1;
        int isNeg = nn * mm;

        for (int i = n1 - 1; i >= 0; i--) {
            if (s1.charAt(i) == '-')
                continue;
            int n1Digit = s1.charAt(i) - '0';
            int carry = 0;
            i2 = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                if (s2.charAt(j) == '-')
                    continue;
                int n2Digit = s2.charAt(j) - '0';
                int sum = n1Digit * n2Digit + result[i1 + i2] + carry;
                carry = sum / 10;
                result[i1 + i2] = sum % 10;
                i2++;

            }
            if (carry > 0) {
                result[i1 + i2] += carry;
            }
            i1++;
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }
        if (i == -1) {
            return "0";

        }
        String s = "";
        while (i >= 0) {
            s += Integer.toString(result[i--]);
        }
        if(isNeg==-1){
            s="-"+s;
        }
return s;
    }
public static void main(String[] args) {
    String s1="123";
    String s2="77";
    System.out.println(mutiplyLarge(s1, s2));

}
}
