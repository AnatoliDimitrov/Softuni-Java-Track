import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    private static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var firstMatrixInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        matrix = new int[firstMatrixInfo[0]][firstMatrixInfo[1]];
        readMatrix(matrix, scanner);

        var element = Integer.parseInt(scanner.nextLine());

        matrixCrawer(element);

    }

    private static void matrixCrawer(int element) {
        var found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == element){
                    System.out.printf("%d %d\n", i, j);
                    found = true;
                }
            }
        }
        if (!found) System.out.println("not found");
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
