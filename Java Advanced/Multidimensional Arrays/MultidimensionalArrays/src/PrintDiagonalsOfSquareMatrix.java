import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    private static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var size = Integer.parseInt(scanner.nextLine());

        matrix = new int[size][size];
        readMatrix(matrix, scanner);
        matrixCrawer();
    }

    private static void matrixCrawer() {
        List<String> firstDiagonal = new ArrayList<>();
        List<String> secondDiagonal = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
                firstDiagonal.add( matrix[i][i] + "");
                secondDiagonal.add(matrix[matrix.length - 1 - i][i] + "");
        }
        System.out.println(String.join(" ", firstDiagonal));
        System.out.println(String.join(" ", secondDiagonal));
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
