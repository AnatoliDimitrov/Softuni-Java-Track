import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> predicate = e -> {
            for (int num : numbers) {
                if (e % num != 0)
                    return  false;
            }
            return true;
        };

        IntStream.rangeClosed(1, n)
                .boxed()
                .filter(predicate)
                .forEach(e -> System.out.print(e + " "));
    }
}