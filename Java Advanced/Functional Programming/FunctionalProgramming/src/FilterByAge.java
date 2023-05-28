import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Supplier<Person> supplier = () -> {
                String[] tokens = scanner.nextLine().split(", ");
                return new Person(tokens[0], Integer.parseInt(tokens[1]));
        };

        List<Person> people = IntStream.range(0, n)
                .mapToObj(ignored -> supplier.get())
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        people = filterPeople(people, condition, age);


        String[] format = scanner.nextLine().split("\\s+");
        format(people, format);

    }

    private static List<Person> filterPeople(List<Person> people, String condition, int age) {
        if (condition.equals("younger")) {
            return people.stream().filter(p -> p.getAge() <= age)
                    .collect(Collectors.toList());
        } else {
            return people.stream().filter(p -> p.getAge() >= age)
                    .collect(Collectors.toList());
        }
    }

    private static void format(List<Person> people, String[] format) {
        if (format.length == 2) {
            people.forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
            return;
        }

        if (format[0].equals("name")) {
            people.forEach(p -> System.out.printf("%s%n", p.getName()));
            return;
        }

        if (format[0].equals("age")) {
            people.forEach(p -> System.out.printf("%s%n", p.getAge()));
            return;
        }
    }
}