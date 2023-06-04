import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {
    private static String[][] field;
    private static int playerRow;
    private static int playerCol;
    private static int touches = 0;
    private static int moves = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        field = new String[dimensions[0]][dimensions[1]];

        for (int i = 0; i < dimensions[0]; i++) {
            var line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                field[i][j] = String.valueOf(line[j]);
                if(line[j].equals("B")){
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        var direction = scanner.nextLine();

        while (!direction.equals("Finish")){
            if (direction.equals("up") && canMove(playerRow - 1, playerCol)){
                field[playerRow][playerCol] = "-";
                playerRow--;
                if (field[playerRow][playerCol].equals("P")){
                    touches++;
                }
                field[playerRow][playerCol] = "B";
                moves++;
            } else if (direction.equals("down") && canMove(playerRow + 1, playerCol)) {
                field[playerRow][playerCol] = "-";
                playerRow++;
                if (field[playerRow][playerCol].equals("P")){
                    touches++;
                }
                field[playerRow][playerCol] = "B";
                moves++;
            } else if (direction.equals("left") && canMove(playerRow, playerCol - 1)) {
                field[playerRow][playerCol] = "-";
                playerCol--;
                if (field[playerRow][playerCol].equals("P")){
                    touches++;
                }
                field[playerRow][playerCol] = "B";
                moves++;
            } else if (direction.equals("right") && canMove(playerRow, playerCol + 1)) {
                field[playerRow][playerCol] = "-";
                playerCol++;
                if (field[playerRow][playerCol].equals("P")){
                    touches++;
                }
                field[playerRow][playerCol] = "B";
                moves++;
            }

            if (touches == 3){
                break;
            }

            direction = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: " + touches + " ");
        System.out.printf("Moves made: " + moves);
    }

    private static boolean canMove(int row, int col) {
        return !(row < 0 || row >= field.length || col < 0 || col >= field[0].length || field[row][col].equals("O"));
    }
}