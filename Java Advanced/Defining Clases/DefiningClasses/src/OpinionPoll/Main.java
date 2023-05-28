package OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        var count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            var info = scanner.nextLine().split("\\s+");
            people.add(new Person(info[0], Integer.parseInt(info[1])));
        }

        people.sort((a, b) -> a.getName().compareTo(b.getName()));

        people
                .stream()
                .filter(p -> p.getAge() > 30)
                .forEach(p -> {
            System.out.printf("%s - %d%n", p.getName(), p.getAge());
        });
    }
}