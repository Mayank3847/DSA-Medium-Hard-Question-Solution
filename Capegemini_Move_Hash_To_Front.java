public class Capegemini_Move_Hash_To_Front {
    public static String moveHash(String str) {
        String str1 = " ";
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                str1 += str.charAt(i);
            } else {
                str2 += str.charAt(i);
            }
        }
        String result = str1 + str2;//str1.concat(str2);
        return result;
    }

    public static void main(String[] args) {
        String str = "Move#Hash#To#Front";
        System.out.println(moveHash(str));
    }
}
