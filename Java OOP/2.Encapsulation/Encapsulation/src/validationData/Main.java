package validationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            var data = scanner.nextLine().split(" ");
            var firstName = data[0];
            var lastName = data[1];
            var age = Integer.parseInt(data[2]);
            var salary = Double.parseDouble(data[3]);

            try {
                var person = new Person(firstName, lastName, age, salary);
                persons.add(person);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        var something = scanner.nextLine();

        persons.forEach(System.out::println);
    }
}