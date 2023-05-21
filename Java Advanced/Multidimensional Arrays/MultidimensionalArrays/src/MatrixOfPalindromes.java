import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    private static String[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        matrix = new String[dimensions[0]][dimensions[1]];
        fillMatrix();
        printMatrix();
    }

    private static void fillMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = ((char)(97 + row)) + "" + ((char)(97 + row + col)) + "" + ((char)(97 + row)) + "";
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
