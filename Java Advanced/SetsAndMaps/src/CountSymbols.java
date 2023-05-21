import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> occurrences = new TreeMap<>();

        var word = scanner.nextLine();

        for (int i = 0; i < word.length(); i++) {
            if (!occurrences.containsKey(word.charAt(i))){
                occurrences.put(word.charAt(i), 0);
            }

            occurrences.put(word.charAt(i), occurrences.get(word.charAt(i)) + 1);
        }

        occurrences.forEach((c, o) -> {
            System.out.printf("%s: %d time/s\n", String.valueOf(c), o);
        });
    }
}