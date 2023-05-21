import java.util.*;
public class TheMatrix {
    public static void main(String[] args) {
        readInput();
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        String str[] = scanner.nextLine().split(" ");
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        char table[][] = new char[r][c];
        String line[];
        for (int i = 0; i < r; i++) {
            line = scanner.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                table[i][j] = line[j].charAt(0);
            }
        }
        char fillChar = scanner.nextLine().charAt(0);
        str = scanner.nextLine().split(" ");
        int startRow = Integer.parseInt(str[0]);
        int startCol = Integer.parseInt(str[1]);
        long startTime = System.currentTimeMillis();
        dfs(table, fillChar, startRow, startCol, table[startRow][startCol]);
        printTable(table);
    }

    public static void dfs(char table[][], char fillChar, int currentRow, int currentCol, char startChar) {
        table[currentRow][currentCol] = fillChar;
        matrixDFSHelper(table, fillChar, currentRow, currentCol, startChar);
    }

    public static void matrixDFSHelper(char table[][], char fillChar, int currentRow, int currentCol, char startChar) {
        if (currentRow + 1 < table.length && table[currentRow + 1][currentCol] == startChar) {
            table[currentRow + 1][currentCol] = fillChar;
            matrixDFSHelper(table, fillChar, currentRow + 1, currentCol, startChar);
        }

        if (currentCol + 1 < table[0].length && table[currentRow][currentCol + 1] == startChar) {
            table[currentRow][currentCol + 1] = fillChar;
            matrixDFSHelper(table, fillChar, currentRow, currentCol + 1, startChar);
        }

        if (currentRow - 1 >= 0 && table[currentRow - 1][currentCol] == startChar) {
            table[currentRow - 1][currentCol] = fillChar;
            matrixDFSHelper(table, fillChar, currentRow - 1, currentCol, startChar);
        }
        if (currentCol - 1 >= 0 && table[currentRow][currentCol - 1] == startChar) {
            table[currentRow][currentCol - 1] = fillChar;
            matrixDFSHelper(table, fillChar, currentRow, currentCol - 1, startChar);
        }
    }

    public static void printTable(char table[][]) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.printf("%c", table[i][j]);
            }
            System.out.printf("\n");
        }
    }
}