import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {

    private static String[][] matrix = new String[8][8];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        readMatrix(scanner);
        matrixCrawer();

        System.out.println();
    }

    private static void matrixCrawer() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].equals("q")){
                    if(realQueen(i, j)){
                        System.out.printf("%d %d", i, j);
                        return;
                    }
                }
            }
        }
    }

    private static boolean realQueen(int row, int col) {
        var valid = Arrays.asList(matrix[row]).contains("q");
        var leftCol = col - 1;
        var rightCol = col + 1;
        if (valid){
            for (int i = row + 1; i < 8; i++) {
                if (matrix[i][col].equals('q')){
                    return false;
                }
                if(leftCol >= 0 && leftCol < 8 && matrix[i][leftCol].equals("q")){
                    return false;
                }
                if(rightCol >= 0 && rightCol < 8 && matrix[i][rightCol].equals("q")){
                    return false;
                }
                leftCol--;
                rightCol++;
            }

            leftCol = col - 1;
            rightCol = col + 1;

            for (int i = row - 1; i >= 0; i--) {
                if (matrix[i][col].equals('q')){
                    return false;
                }
                if(leftCol >= 0 && leftCol < 8 && matrix[i][leftCol].equals("q")){
                    return false;
                }
                if(rightCol >= 0 && rightCol < 8 && matrix[i][rightCol].equals("q")){
                    return false;
                }
                leftCol--;
                rightCol++;
            }
        }
        return valid;
    }

    private static void readMatrix(Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }
}
