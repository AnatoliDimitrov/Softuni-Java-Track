package customListSorter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Add" -> list.add(commands[1]);
                case "Remove" -> list.remove(Integer.parseInt(commands[1]));
                case "Contains" -> System.out.println(list.contains(commands[1]));
                case "Swap" -> list.swap(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                case "Greater" -> System.out.println(list.countGreaterThan(commands[1]));
                case "Max" -> System.out.println(list.getMax());
                case "Min" -> System.out.println(list.getMin());
                case "Print" -> System.out.println(list);
                case "Sort" -> Sorter.sort(list);
            }
            input = scanner.nextLine();
        }
    }
}