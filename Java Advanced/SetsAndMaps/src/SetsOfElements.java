import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        int[] nm = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < nm[0]; i++) {
            first.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < nm[1]; i++) {
            second.add(Integer.parseInt(scanner.nextLine()));
        }

        first.retainAll(second);

        first.forEach(i -> {
            System.out.print(i + " ");
        });
    }
}