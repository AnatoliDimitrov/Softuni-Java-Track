import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> people = new TreeSet<>();

        var person = scanner.nextLine();

        while(!person.equals("PARTY")){
            people.add(person);

            person = scanner.nextLine();
        }

        person = scanner.nextLine();

        while (!person.equals("END")){
            people.remove(person);
            person = scanner.nextLine();
        }

        System.out.println(people.size());
        System.out.println(String.join("\n", people));
    }
}