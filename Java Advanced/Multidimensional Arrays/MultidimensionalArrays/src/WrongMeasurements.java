import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    private static int[][] matrix;
    private static int[][] result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var size = Integer.parseInt(scanner.nextLine());

        matrix = new int[size][];
        result = new int[size][];
        readMatrix(matrix, scanner);
        var location = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        var wrongValue = matrix[location[0]][location[1]];
        matrixCrawer(wrongValue);
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%d ", result[i][j]);
            }
            System.out.println();
        }
    }

    private static void matrixCrawer(int wrongValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == wrongValue){
                    var sum = 0;
                    sum += checkNeighbor(i + 1, j, wrongValue);
                    sum += checkNeighbor(i - 1, j, wrongValue);
                    sum += checkNeighbor(i, j + 1, wrongValue);
                    sum += checkNeighbor(i, j - 1, wrongValue);
                    result[i][j] = sum;

                } else {
                    result[i][j] = matrix[i][j];
                }
            }
        }
    }

    private static int checkNeighbor(int row, int col, int wrongValue){
        var len = matrix.length;
        if(row >= 0 && row < len && col >= 0 && col < matrix[row].length && matrix[row][col] != wrongValue){
            return matrix[row][col];
        }
        return 0;
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            result[i] = new int[matrix[i].length];
        }
    }
}
