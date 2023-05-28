import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println("Prices with VAT:");
        Arrays.stream(prices).map(p -> p * 1.2)
                .forEach(p -> System.out.printf("%.2f%n", p));
    }
}