import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        var input = scanner.nextLine();

        while (!input.equals("search")){
            var info = input.split("-");

            phonebook.put(info[0], info[1]);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")){
            if (phonebook.containsKey(input)){
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }

            input = scanner.nextLine();
        }
    }
}