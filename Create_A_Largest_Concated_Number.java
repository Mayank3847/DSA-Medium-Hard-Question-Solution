import java.util.Arrays;
import java.util.Comparator;

public class Create_A_Largest_Concated_Number {
    public static String largestConcatedNumber(int arr[]) {
        String[] strNums = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strNums[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        if (strNums[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String str : strNums) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 30, 34, 5, 9 };
        System.out.println(largestConcatedNumber(arr));
    }
}
