import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> people = new LinkedHashMap<>();

        while (true){
            var name = scanner.nextLine();

            if (name.equals("stop")){
                break;
            }

            var email = scanner.nextLine();

            if (email.endsWith(".com") || email.endsWith(".us") || email.endsWith(".uk")){
                continue;
            }

            people.put(name, email);
        }

        people.forEach((n, e) -> {
            System.out.printf("%s -> %s%n", n, e);
        });
    }
}