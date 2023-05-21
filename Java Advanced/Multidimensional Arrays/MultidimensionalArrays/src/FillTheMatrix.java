import java.util.Scanner;

public class FillTheMatrix {
    private static Integer[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var commands = scanner.nextLine().split(", ");
        var size = Integer.parseInt(commands[0]);
        var type = commands[1];
        matrix = new Integer[size][size];

        if (type.equals("A")) fillA();
        else fillB();

        printMatrix();
    }

    private static void fillB() {
        var counter = 0;
        for (int col = 0; col < matrix.length; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    counter++;
                    matrix[row][col] = counter;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    counter++;
                    matrix[row][col] = counter;
                }
            }
        }
    }

    private static void fillA() {
        var counter = 0;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                counter++;
                matrix[row][col] = counter;
            }
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
}
