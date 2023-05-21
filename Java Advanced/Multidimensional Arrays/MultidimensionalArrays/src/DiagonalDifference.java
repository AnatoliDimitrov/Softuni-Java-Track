import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var size = Integer.parseInt(scanner.nextLine());

        matrix = new int[size][size];
        readMatrix(scanner);
        int result = findDiagonalDifference();
        System.out.println(result);
    }

    private static int findDiagonalDifference() {
        var firstDiagonalSum = 0;
        var secondDiagonalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            firstDiagonalSum += matrix[i][i];
            secondDiagonalSum += matrix[i][matrix.length - 1 - i];
        }

        return Math.abs(firstDiagonalSum - secondDiagonalSum);
    }

    private static void readMatrix(Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
