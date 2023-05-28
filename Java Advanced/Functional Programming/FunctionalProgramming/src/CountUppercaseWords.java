import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        var text = scanner.nextLine().split("\\s+");

        var capitalWords = Arrays.stream(text)
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
        capitalWords.forEach(System.out::println);
    }
}