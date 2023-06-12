package collection;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] lines = scanner.nextLine().split("\\s+");

        ListyIterator listyIterator = new ListyIterator();

        listyIterator.create(lines);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            switch (command) {
                case "HasNext" -> System.out.println(listyIterator.hasNext());
                case "Print" -> listyIterator.print();
                case "Move" -> System.out.println(listyIterator.move());
                case "PrintAll" -> listyIterator.printAll();
                default -> {
                }
            }
            command = scanner.nextLine();
        }
    }
}