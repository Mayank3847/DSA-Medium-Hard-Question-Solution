import java.util.*;

public class Capegemini_Search_In_Matrix {

    public static List<Integer> searchMatrix(int mat[][], int target) {
        List<Integer> list = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == target) {
                    list.add(i);
                    list.add(j);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            list.add(-1);
            list.add(-1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 8, 12, 16 },
                { 3, 7, 9, 10 },
                { 6, 14, 2, 11 }
        };
        int target = 11;
        System.out.println(searchMatrix(matrix, target));
    }
}