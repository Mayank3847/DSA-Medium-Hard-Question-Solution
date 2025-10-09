public class Capegemini_ZigZag_Snake_Pattern {

    public static int[][] zigzagPattern(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int result[][] = new int[n][m];
        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    result[r][c] = matrix[i][j];
                    c++;
                    if (c == m) {
                        c = 0;
                        r++;

                    }
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    result[r][c] = matrix[i][j];
                    c++;
                    if (c == m) {
                        c = 0;
                        r++;

                    }
                }
            }
        }
        return result;
    }

    public static int[][] zigzagPatternColumnWise(int matrix[][]) {
        int c = 0;
        int r = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int result[][] = new int[n][m];
        for (int j = 0; j < m; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    result[r][c] = matrix[i][j];
                    c++;
                    if (c == m) {
                        c = 0;
                        r++;
                    }
                }

            } else {
                for (int i = n - 1; i >= 0; i--) {
                    result[r][c] = matrix[i][j];
                    c++;
                    if (c == m) {
                        c = 0;
                        r++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int snake[][] = zigzagPattern(mat);
        for (int i = 0; i < snake.length; i++) {
            for (int j = 0; j < snake[0].length; j++) {
                System.out.print(snake[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println("Column wise zig pattern output");
        int snake1[][] = zigzagPatternColumnWise(mat);
        for (int i = 0; i < snake1.length; i++) {
            for (int j = 0; j < snake1[0].length; j++) {
                System.out.print(snake1[i][j] + " ");
            }
            System.out.println();

        }
    }
}