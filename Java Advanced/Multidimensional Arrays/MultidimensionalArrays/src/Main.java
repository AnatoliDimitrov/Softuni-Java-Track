import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[][] first;
    private static int[][] second;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var firstMatrixInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        first = new int[firstMatrixInfo[0]][firstMatrixInfo[1]];
        readMatrix(first, scanner);

        var secondMatrixInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if(firstMatrixInfo[0] != secondMatrixInfo[0] || firstMatrixInfo[1] != secondMatrixInfo[1]){
            System.out.println("not equal" );
            return;
        }

        second = new int[firstMatrixInfo[0]][firstMatrixInfo[1]];
        readMatrix(second, scanner);

        if(Arrays.deepEquals(first, second)){
            System.out.println("equal" );
        } else {
            System.out.println("not equal" );
        }
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}