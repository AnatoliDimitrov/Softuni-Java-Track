import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    private static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var info = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        matrix = new int[info[0]][info[1]];
        readMatrix(matrix, scanner);
        matrixCrawer();
    }

    private static void matrixCrawer() {
        var sum = Long.MIN_VALUE;
        var currentSum = 0;
        var result = "";
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                currentSum = matrix[i][j] + matrix[i][j + 1] +
                matrix[i + 1][j] + matrix[i + 1][j + 1];

                if(currentSum > sum){
                    sum = currentSum;
                    result = String.format("%d %d\n%d %d", matrix[i][j], matrix[i][j + 1], matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
            }
        }
        System.out.println(result);
        System.out.println(sum);
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
