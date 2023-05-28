package TheSquirrel;

import java.util.Scanner;
public class Main {

    private static String[][] field;
    private static String[] directions;

    private static int row;
    private static int col;

    private static String message = "";

    private static int hazelnuts = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var size = Integer.parseInt(scanner.nextLine());
        field = new String[size][size];
        directions = scanner.nextLine().split(", ");

        fillMatrix(scanner, size);

        for (int i = 0; i < directions.length; i++) {
            move(directions[i]);
            if (!message.equals("")){
                System.out.println(message);
                break;
            }
        }

        if(message.equals("")){
            System.out.println("There are more hazelnuts to collect.");
        }

        System.out.println("Hazelnuts collected: " + hazelnuts);
    }

    private static void move(String direction) {
        field[row][col] = "*";
        if(direction.equals("up")){
            checkDirection(row - 1, col);
        } else if(direction.equals("left")){
            checkDirection(row , col - 1);
        } else if (direction.equals("right")) {
            checkDirection(row, col + 1);
        } else if (direction.equals("down")) {
            checkDirection(row + 1, col);
        }
    }

    private static void checkDirection(int currentRow, int currentCol) {
        if (currentRow < 0 || currentRow >= field.length || currentCol < 0 || currentCol >= field.length){
            message = "The squirrel is out of the field.";
            return;
        }
        if (field[currentRow][currentCol].equals("t")){
            message = "Unfortunately, the squirrel stepped on a trap...";
            return;
        }
        if (field[currentRow][currentCol].equals("h")){
            hazelnuts++;
            field[currentRow][currentCol] = "s";
            row = currentRow;
            col = currentCol;
            if (hazelnuts == 3){
                message = "Good job! You have collected all hazelnuts!";
                return;
            }
        }
        if(field[currentRow][currentCol].equals("*")){
            field[currentRow][currentCol] = "s";
            row = currentRow;
            col = currentCol;
        }
    }

    private static void fillMatrix(Scanner scanner, int size) {
        for (int i = 0; i < size; i++) {
            var line = scanner.nextLine();
            for (int j = 0; j < size; j++) {
                field[i][j] = line.charAt(j) + "";
                if(field[i][j].equals("s")){
                    row = i;
                    col = j;
                }
            }
        }
    }
}