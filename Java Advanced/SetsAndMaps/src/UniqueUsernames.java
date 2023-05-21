import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new LinkedHashSet<>();

        var counter = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < counter; i++) {
            words.add(scanner.nextLine());
        }

        words.forEach(word -> {
            System.out.println(word);
        });
    }
}