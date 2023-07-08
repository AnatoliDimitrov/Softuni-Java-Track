import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(i, n);
            System.out.println();
        }

        for (int i = n - 1; i >= 0; i--) {
            printRow(i, n);
            if (i > 1) {
                System.out.println();
            }
        }
    }

    private static void printRow(int i, int n) {
        System.out.print(" ".repeat(n - i));
        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
    }
}