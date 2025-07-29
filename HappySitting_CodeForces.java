import java.util.*;

public class HappySitting_CodeForces {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Test Cases -> ");
        int tc = sc.nextInt();
        while (tc-- > 0) {
            System.out.println("Enter the number of Family Member -> ");

            int n = sc.nextInt();
            System.out.println("Enter the number of Rows -> ");

            int r = sc.nextInt();
            int[] a = new int[n];
            System.out.println("Enter the Member of Family Member -> ");
            int totalPeople = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();  
                totalPeople+=a[i];
            }

            int pairedPeople = 0;
            int singlePeople = 0;
            for (int i = 0; i < n; i++) {
                int pairs = a[i] / 2;
                pairedPeople += pairs * 2;
                if (a[i] % 2 == 1) {
                    singlePeople++;
                }

            }
           
            
          
           int emptySeats = 2 * r - totalPeople;
            int singleHappy = Math.min(singlePeople, emptySeats);
            int totalHappy = singleHappy + pairedPeople;
            System.out.println(totalHappy);

        }
        sc.close();
    }
}