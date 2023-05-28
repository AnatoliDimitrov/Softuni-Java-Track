import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        var evenNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(evenNumbers.stream().sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}