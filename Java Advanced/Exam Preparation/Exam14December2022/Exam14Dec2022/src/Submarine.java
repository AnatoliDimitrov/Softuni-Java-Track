import java.util.Scanner;

public class Submarine {
    private static String[][] field;
    private static int row;
    private static int col;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var destroyedEnemies = 0;
        var mineHits = 0;
        var resultMessage = "";

        var size = Integer.parseInt(scanner.nextLine());
        field = new String[size][size];

        for (int i = 0; i < size; i++) {
            var line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                field[i][j] = String.valueOf(line.charAt(j));
                if (field[i][j].equals("S")){
                    row = i;
                    col = j;
                }
            }
        }

        while (true){
            var command = scanner.nextLine();
            field[row][col] = "-";

            if (command.equals("up")){
                row--;
            } else if (command.equals("left")) {
                col--;
            } else if (command.equals("right")) {
                col++;
            } else if (command.equals("down")) {
                row++;
            }

            if(field[row][col].equals("*")){
                mineHits++;
            }
            if(field[row][col].equals("C")){
                destroyedEnemies++;
            }

            field[row][col] = "S";

            if (destroyedEnemies == 3){
                resultMessage = "Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!";
                break;
            }
            if (mineHits == 3){
                resultMessage = String.format("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!", row, col);
                break;
            }
        }

        System.out.println(resultMessage);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf(field[i][j]);
            }
            System.out.println();
        }
    }
}