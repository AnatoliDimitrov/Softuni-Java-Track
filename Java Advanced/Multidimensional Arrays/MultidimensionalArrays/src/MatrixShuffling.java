import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    private static int[][] matrix;
    private static int[] coordinates;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var info = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        matrix = new int[info[0]][info[1]];
        readMatrix(matrix, scanner);
        System.out.println();

        var command = scanner.nextLine();

        while (!command.equals("END")){
            if(validateInput(command)){
               swapElements();
               printMatrix();
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void swapElements() {
        var temp = matrix[coordinates[0]][coordinates[1]];
        matrix[coordinates[0]][coordinates[1]] = matrix[coordinates[2]][coordinates[3]];
        matrix[coordinates[2]][coordinates[3]] = temp;
    }

    private static boolean validateInput(String command) {
        var valid = false;
        if (command.startsWith("swap ")){
            command = command.replace("swap ", "");
            coordinates = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (coordinates.length != 4) {
                valid = false;
            } else {
                valid = coordinates[0] >= 0 && coordinates[0] < matrix.length &&
                        coordinates[1] >= 0 && coordinates[1] < matrix[0].length &&
                        coordinates[2] >= 0 && coordinates[2] < matrix.length &&
                        coordinates[3] >= 0 && coordinates[3] < matrix[0].length;

            }
        }

        return valid;
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
