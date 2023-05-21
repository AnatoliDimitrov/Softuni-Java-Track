import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedNumbers = Arrays
                .stream(scanner.nextLine().split((" ")))
                .map(Integer::parseInt)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedNumbers.size() && i < 3; i++) {
            System.out.print(sortedNumbers.get(i) + " ");
        }
    }
}