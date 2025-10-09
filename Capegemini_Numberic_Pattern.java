public class Capegemini_Numberic_Pattern {
    public static void rightAlignedNumberPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int num = 1; num <= i; num++) {
                System.out.print(num + " ");
            }

            System.out.println();
        }

    }

    public static void centeredNumbericPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int num = 1; num <= i; num++) {
                System.out.print(num + "");
            }

            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + "");
            }
            System.out.println();
        }
    }

    public static void invertedTriangle(int n) {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void repeatingRowNumber(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void continuousNumber(int n) {
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(cnt + " ");
                cnt++;
            }
            System.out.println();
        }
    }

    public static void mirrorTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int num = 1; num <= i; num++) {
                System.out.print(num + "");
            }

            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int num = 1; num <= i; num++) {
                System.out.print(num + "");
            }
            System.out.println();
        }
    }

    public static void diagonaal(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp < i; sp++) {
                System.out.print(" ");
            }
            System.out.println(i);
        }
    }

    public static void rowWiseContantIncrement(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((j + i - 1) + " ");
            }
            System.out.println();
        }
    }

    public static void reversePyramid(int n) {
        for (int i = n; i >= 1; i--) {
            for (int sp = 1; sp <= n-i; sp++) {
                System.out.print(" ");
            }
            for (int num = i; num >= 1; num--) {
                System.out.print(  num +" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Right Aligned Triangle Number");
        rightAlignedNumberPattern(n);
        System.out.println("Centered Numberic Pyramid :- ");
        centeredNumbericPyramid(n);
        System.out.println("Inverted Triangle");
        invertedTriangle(n);
        System.out.println("Repeating Row Number ");
        repeatingRowNumber(n);
        System.out.println("Continuous Number :-");
        continuousNumber(n);
        System.out.println("Mirror Triangle :-");

        mirrorTriangle(n);
        System.out.println("Diagonal Pattern  :-");
        diagonaal(n);
        System.out.println("Row Wise Constant Increment :-");
        rowWiseContantIncrement(n);
        System.out.println("Reverse Pyramid :-");
        reversePyramid(n);
    }

}
