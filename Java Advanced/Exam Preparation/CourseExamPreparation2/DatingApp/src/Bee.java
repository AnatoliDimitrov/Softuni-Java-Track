import java.util.Scanner;

public class Bee {
    private static String[][] field;
    private static int allFlowers = 0;
    private static int pollinatedFlowers = 0;
    private static int row = 0;
    private static int col = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var size = Integer.parseInt(scanner.nextLine());

        field = new String[size][size];

        for (int i = 0; i < size; i++) {
            var line = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                field[i][j] = line[j];
                if (line[j].equals("B")) {
                    row = i;
                    col = j;
                } else if (line[j].equals("f")) {
                    allFlowers++;
                }
            }
        }

        var direction = scanner.nextLine();

        while (!direction.equals("End")) {
            field[row][col] = ".";

            if (direction.equals("up")) {
                row--;
            } else if (direction.equals("down")) {
                row++;
            } else if (direction.equals("left")) {
                col--;
            } else if (direction.equals("right")) {
                col++;
            }

            if (beeIsOut()){
                System.out.println("The bee got lost!");
                break;
            }

            if (field[row][col].equals("f")){
                pollinatedFlowers++;
            } else if (field[row][col].equals("O")){
                field[row][col] = "B";
                continue;
            }

            field[row][col] = "B";
            direction = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - pollinatedFlowers);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println(String.join("", field[i]));
        }
    }

    private static boolean beeIsOut() {
        return row < 0 || row >= field.length || col < 0 || col >= field.length;
    }
}
