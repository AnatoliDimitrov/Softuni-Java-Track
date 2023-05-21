import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    private static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimenssions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        matrix = new int[dimenssions[0]][dimenssions[1]];
        readMatrix(scanner);

        for (int col = matrix[0].length - 1; col >= 0; col--) {
            System.out.print(matrix[matrix.length - 1][col] + " ");
            var currentCol = col;
            for (int row = matrix.length - 2; row >= 0; row--) {
                if (currentCol + 1 >= matrix[0].length) break;

                System.out.print(matrix[row][currentCol + 1] + " ");
                currentCol++;
            }
            System.out.println();
        }

        if(matrix.length > 1){
            for (int row = matrix.length - 2; row >= 0; row--) {
                System.out.print(matrix[row][0] + " ");

                var currentCol = 0;
                for (int innerRow = row - 1; innerRow >= 0; innerRow--) {
                    if (currentCol + 1 >= matrix[0].length) break;

                    System.out.print(matrix[innerRow][currentCol + 1] + " ");
                    currentCol++;
                }
                System.out.println();
            }
        }
    }
    private static void readMatrix(Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}