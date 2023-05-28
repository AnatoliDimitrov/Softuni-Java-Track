import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        var num = Integer.parseInt(scanner.nextLine());

        numbers.removeIf(e -> e % num == 0);
        Collections.reverse(numbers);

        numbers.forEach(e -> System.out.print(e + " "));

    }
}