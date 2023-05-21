import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    private static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var info = Arrays.stream(scanner.nextLine().split(" "))
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
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if(currentSum > sum){
                    sum = currentSum;
                    result = String.format("%d %d %d\n%d %d %d\n%d %d %d", matrix[i][j], matrix[i][j + 1], matrix[i][j + 2],
                            matrix[i + 1][j], matrix[i + 1][j + 1], matrix[i + 1][j + 2],
                            matrix[i + 2][j], matrix[i + 2][j + 1], matrix[i + 2][j + 2]);
                }
            }
        }
        System.out.println("Sum = " + sum);
        System.out.println(result);
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
