import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        var command = scanner.nextLine();
        while (!command.equals("Party!")) {
            var info = command.split("\\s+");


            if (info[0].equals("Remove")) {
                switch (info[1]) {
                    case "StartsWith":
                        var letter = info[2].charAt(0);
                        people.removeIf(e -> e.charAt(0) == letter);
                        break;
                    case "EndsWith":
                        letter = info[2].charAt(0);
                        people.removeIf(e -> e.charAt(e.length() - 1) == letter);
                        break;
                    case "Length":
                        var length = Integer.parseInt(info[2]);
                        people.removeIf(e -> e.length() == length);
                        break;
                }
            } else if (info[0].equals("Double")) {
                switch (info[1]) {
                    case "StartsWith":
                        var letter = info[2];
                        var peopleToAdd = people.stream().filter(e -> e.startsWith(letter)).collect(Collectors.toList());
                        people.addAll(peopleToAdd);
                        break;
                    case "EndsWith":
                        letter = info[2];
                        peopleToAdd = people.stream().filter(e -> e.endsWith(letter)).collect(Collectors.toList());
                        people.addAll(peopleToAdd);
                        break;
                    case "Length":
                        var length = Integer.parseInt(info[2]);
                        peopleToAdd = people.stream().filter(e -> e.length() == length).collect(Collectors.toList());
                        people.addAll(peopleToAdd);
                        break;
                }
            }
            command = scanner.nextLine();
        }

        if (!people.isEmpty()) {
            Collections.sort(people);
            System.out.printf("%s are going to the party!%n", String.join(", ", people));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}