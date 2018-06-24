import java.util.*;

import jdk.nashorn.internal.runtime.Undefined;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
        };

        System.out.println(isToeplitzMatrix(matrix));
        System.out.println(isToeplitzMatrixx(matrix));
	}
    
    private static boolean isToeplitzMatrix(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length + matrix[0].length - 1; i++) {
            Integer temp = null;
            count++;

            for (int j = 0; j < matrix.length; j++) {
                count++;
                int index = i + j - matrix.length + 1;
                if (index >= 0 && index < matrix[0].length) {
                    if (temp == null)   temp = matrix[j][index];
                    else if (temp != matrix[j][index])  return false;
                }
            }
        }

        System.out.println(count);
        return true;
    }

    private static boolean isToeplitzMatrixx(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            count++;
            for (int j = 0; j < matrix[i].length - 1; j++) {
                count++;
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        System.out.println(count);
        return true;
    }
}