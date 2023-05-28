import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicateMap = new HashMap<>();

        var command = scanner.nextLine();
        while (!command.equals("Print")) {
            var info = command.split(";");
            var name = info[1].split("\\s+")[0] + info[2];

            Predicate<String> predicate = getPredicate(info[1], info[2]);

            if (command.contains("Add")) {
                predicateMap.putIfAbsent(name, predicate);
            } else if (command.contains("Remove")) {
                predicateMap.remove(name);
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Predicate<String>> entry : predicateMap.entrySet()) {
            people.removeIf(entry.getValue());
        }

        System.out.println(String.join(" ", people));
    }

    public static Predicate<String> getPredicate (String action, String parameter) {
        switch (action) {
            case "Starts with":
                return e -> e.startsWith(parameter);
            case "Ends with":
                return e -> e.endsWith(parameter);
            case "Length":
                return e -> e.length() == Integer.parseInt(parameter);
            case "Contains":
                return e -> e.contains(parameter);
        }
        return null;
    }
}