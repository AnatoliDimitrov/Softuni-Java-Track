import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    private static String[][] field;
    private static int row;
    private static int col;
    private static int cheesesCount = 0;
    private static int chessesEaten = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var dimensions = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        field = new String[dimensions[0]][dimensions[1]];

        for (int i = 0; i < dimensions[0]; i++) {
            var line = scanner.nextLine().split("");
            for (int j = 0; j < line.length; j++) {
                var currentSymbol = line[j];
                field[i][j] = currentSymbol;
                if (currentSymbol.equals("M")){
                    row = i;
                    col = j;
                }
                if (currentSymbol.equals("C")){
                    cheesesCount++;
                }
            }
        }

        var command = scanner.nextLine();
        var messagePrinted = false;

        while (!command.equals("danger")){
            if (command.equals("left")){
                if (mouseIsOut(row, col - 1)){
                    System.out.println("No more cheese for tonight!");
                    messagePrinted = true;
                    break;
                }
                if (field[row][col - 1].equals("@")){
                    command = scanner.nextLine();
                    continue;
                }
                field[row][col] = "*";
                col--;
            } else if (command.equals("right")){
                if (mouseIsOut(row, col + 1)){
                    System.out.println("No more cheese for tonight!");
                    messagePrinted = true;
                    break;
                }
                if (field[row][col + 1].equals("@")){
                    command = scanner.nextLine();
                    continue;
                }
                field[row][col] = "*";
                col++;
            } else if (command.equals("up")){
                if (mouseIsOut(row - 1, col)){
                    System.out.println("No more cheese for tonight!");
                    messagePrinted = true;
                    break;
                }
                if (field[row - 1][col].equals("@")){
                    command = scanner.nextLine();
                    continue;
                }
                field[row][col] = "*";
                row--;
            } else if (command.equals("down")){
                if (mouseIsOut(row + 1, col)){
                    System.out.println("No more cheese for tonight!");
                    messagePrinted = true;
                    break;
                }
                if (field[row + 1][col].equals("@")){
                    command = scanner.nextLine();
                    continue;
                }
                field[row][col] = "*";
                row++;
            }

            if (field[row][col].equals("C")){
                chessesEaten++;
            }
            if (field[row][col].equals("T")){
                field[row][col] = "M";
                System.out.println("Mouse is trapped!");
                messagePrinted = true;
                break;
            }
            if (chessesEaten == cheesesCount){
                field[row][col] = "M";
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                messagePrinted = true;
                break;
            }

            field[row][col] = "M";

            command = scanner.nextLine();
        }

        if (chessesEaten < cheesesCount && !messagePrinted){
            System.out.println("Mouse will come back later!");
        }

        for (int i = 0; i < field.length; i++) {
            System.out.println(String.join("", field[i]));
        }
    }

    private static boolean mouseIsOut(int currentRow, int currentCol) {
        return currentRow < 0 || currentRow >= field.length || currentCol < 0 || currentCol >= field[0].length;
    }
}