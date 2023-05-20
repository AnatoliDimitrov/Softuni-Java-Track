import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    private static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var info = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        matrix = new int[info[0]][info[1]];
        readMatrix(matrix, scanner);
        var sum = matrixCrawer();

        System.out.println(info[0]);
        System.out.println(info[1]);
        System.out.println(sum);
    }

    private static long matrixCrawer() {
        var sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
