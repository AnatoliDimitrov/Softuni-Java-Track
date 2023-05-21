import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

    private static String[][] matrix;
    private static String[][] result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var degrees = Integer.parseInt(scanner.nextLine().split("[(]")[1].replace(")", ""));
        var rotations = (degrees % 360) / 90;

        List<String> words = new ArrayList<>();
        var biggestWord = 0;
        var input = scanner.nextLine();
        while (!input.equals("END")){
            if (input.length() > biggestWord) biggestWord = input.length();
            words.add(input);

            input = scanner.nextLine();
        }

        matrix = new String[words.size()][biggestWord];

        for (int i = 0; i < matrix.length; i++) {
            var word = words.get(i);
            for (int j = 0; j < matrix[i].length; j++) {
                if (j < word.length()){
                    matrix[i][j] = word.charAt(j) + "";
                } else {
                    matrix[i][j] = " ";
                }
            }
        }

        if (rotations == 1) {
            rotate90Degrees(biggestWord, words.size());
        } else if (rotations == 2){
            rotate90Degrees(biggestWord, words.size());
            rotate90Degrees(words.size(), biggestWord);
        } else if (rotations == 3) {
            rotate90Degrees(biggestWord, words.size());
            rotate90Degrees(words.size(), biggestWord);
            rotate90Degrees(biggestWord, words.size());
        }

        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%s", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void rotate90Degrees(int rows, int cols) {
        result = new String[rows][cols];

        for (int col = 0; col < rows; col++) {
            for (int row = 0; row < cols; row++) {
                result[col][cols - row - 1] = matrix[row][col];
            }
        }

        matrix = result;
    }
}
