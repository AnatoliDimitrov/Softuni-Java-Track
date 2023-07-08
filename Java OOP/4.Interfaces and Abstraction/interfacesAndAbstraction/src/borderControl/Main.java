package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> city = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            if (tokens.length == 2) {
                Robot robot = new Robot(tokens[1], tokens[0]);
                city.add(robot);
            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                city.add(citizen);
            }
            input = scanner.nextLine();
        }
        String lastDigit = scanner.nextLine();

        printFakeIdInCity(city, lastDigit);
    }

    private static void printFakeIdInCity(List<Identifiable>list, String lastDigit) {
        for (Identifiable element : list) {
            if (element.getId().endsWith(lastDigit)) {
                System.out.println(element.getId());
            }
        }
    }
}