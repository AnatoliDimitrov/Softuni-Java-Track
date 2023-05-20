import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    private static String[][] first;
    private static String[][] second;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var rows = Integer.parseInt(scanner.nextLine());
        var cols = Integer.parseInt(scanner.nextLine());

        first = new String[rows][cols];
        readMatrix(first, scanner);
        second = new String[rows][cols];
        readMatrix(second, scanner);
        System.out.println("");

        compareMatrices();
    }

    private static void compareMatrices() {
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                System.out.printf("%s ", first[i][j].equals(second[i][j]) ? first[i][j] : "*");
            }
            System.out.println();
        }
    }


    private static void readMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }
}
