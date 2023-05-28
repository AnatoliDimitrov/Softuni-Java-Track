import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String criteria = scanner.nextLine();
        Predicate<Integer> predicate = (criteria.equals("even"))
                ? n -> n % 2 == 0
                : n -> n % 2 != 0;

        print(range[0], range[1], predicate);

    }

    private static void print(int start, int end, Predicate<Integer> predicate) {
        System.out.println(IntStream.rangeClosed(start, end)
                .boxed()
                .filter(predicate)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}