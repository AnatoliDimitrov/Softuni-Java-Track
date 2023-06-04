package CatLady;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Cat> cats = new HashMap<>();
        String input;

        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");
            String type = tokens[0];
            String name = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            Cat cat = switch (type) {
                case "StreetExtraordinaire" -> new StreetExtraordinaire(name, value);
                case "Siamese" -> new Siamese(name, value);
                case "Cymric" -> new Cymric(name, value);
                default -> null;
            };
            if (cat != null) {
                cats.put(name, cat);
            }
        }
        String catName = scanner.nextLine();

        if (cats.containsKey(catName)) {
            System.out.println(cats.get(catName));
        }
    }
}