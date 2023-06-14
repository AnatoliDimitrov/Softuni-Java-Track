import java.util.Scanner;

public class PresentDelivery {

    private static String[][] field;
    private static int row = 0;
    private static int col = 0;
    private static int niceKids = 0;
    private static int giftedKids = 0;
    private static int presentsCount = 0;
    private static boolean noMorePresnts = false;
    private static boolean inC = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presentsCount = Integer.parseInt(scanner.nextLine());
        var size = Integer.parseInt(scanner.nextLine());

        field = new String[size][size];

        for (int i = 0; i < size; i++) {
            var line = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                var currentSymbol = line[j];
                if (currentSymbol.equals("S")) {
                    row = i;
                    col = j;
                }
                if (currentSymbol.equals("V")) {
                    niceKids++;
                }
                field[i][j] = line[j];
            }
        }

        var command = scanner.nextLine();

        while (!command.equals("Christmas morning")) {
            field[row][col] = "-";
            var currentRow = row;
            var currentCol = col;
            if (command.equals("up")) {
                row--;
            } else if (command.equals("right")) {
                col++;
            } else if (command.equals("down")) {
                row++;
            } else if (command.equals("left")) {
                col--;
            }

            if (field[row][col].equals("C")) {
                spreadPresents();
            } else if (field[row][col].equals("V")) {
                presentsCount--;
                giftedKids++;
            }

            field[row][col] = "S";
            if (presentsCount == 0){
                noMorePresnts = true;
            }
            if (noMorePresnts && !inC) {
                System.out.println("Santa ran out of presents!");
                break;
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < size; i++) {
            System.out.println(String.join(" ", field[i]));
        }

        if (giftedKids == niceKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", niceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKids - giftedKids);
        }
    }

    private static void spreadPresents() {
        checkForKid(row, col - 1);
        if (noMorePresnts) {
            return;
        }
        checkForKid(row, col + 1);
        if (noMorePresnts) {
            return;
        }
        checkForKid(row - 1, col);
        if (noMorePresnts) {
            return;
        }
        checkForKid(row + 1, col);
    }

    private static void checkForKid(int row, int col) {
        if (field[row][col].equals("X")) {
            field[row][col] = "-";
            presentsCount--;
        }
        if (presentsCount == 0) {
            noMorePresnts = true;
            inC = true;
            return;
        }
        if (field[row][col].equals("V")) {
            field[row][col] = "-";
            giftedKids++;
            presentsCount--;
        }
        if (presentsCount == 0) {
            noMorePresnts = true;
            inC = true;
        }
    }
}