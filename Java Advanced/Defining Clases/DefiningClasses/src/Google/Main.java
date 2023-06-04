package Google;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Person> people = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        gatherPersonalInformation();

        String person = scanner.nextLine();

        if (people.containsKey(person)) {
            System.out.print(people.get(person));
        }


    }

    private static void gatherPersonalInformation() throws IOException {
        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            people.putIfAbsent(personName, new Person(personName));

            Person person = people.get(personName);
            String command = tokens[1];
            switch (command) {
                case "company" -> person.setCompany(new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                case "pokemon" -> person.add(new Pokemon(tokens[2], tokens[3]));
                case "parents" -> person.add(new Parent(tokens[2], tokens[3]));
                case "children" -> person.add(new Child(tokens[2], tokens[3]));
                case "car" -> person.setCar(new Car(tokens[2], tokens[3]));
            }
        }
    }
}