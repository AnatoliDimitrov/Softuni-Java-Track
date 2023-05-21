import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        for (double num : nums) {
            if (!occurrences.containsKey(num)) {
                occurrences.put(num, 1);
            } else {
                occurrences.put(num, occurrences.get(num) + 1);
            }
        }

        for (var occurrence: occurrences.entrySet()) {
            System.out.printf("%.1f -> %d\n", occurrence.getKey(), occurrence.getValue());
        }
    }
}