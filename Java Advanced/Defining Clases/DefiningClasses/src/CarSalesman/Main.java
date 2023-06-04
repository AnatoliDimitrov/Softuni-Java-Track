package CarSalesman;

import java.io.IOException;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Car> cars = new ArrayList<>();
    private static final Map<String, Engine> engines = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        getEngines();
        getCars();

        cars.forEach(System.out::println);
    }

    private static void getCars() throws IOException {
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            var tokens = scanner.nextLine().split("\\s+");
            var model = tokens[0];
            var engine = engines.get(tokens[1]);
            switch (tokens.length) {
                case 4 -> cars.add(new Car(model, engine, tokens[2], tokens[3]));
                case 3 -> cars.add(new Car(model, engine, tokens[2]));
                case 2 -> cars.add(new Car(model, engine));
            }
        }
    }

    private static void getEngines() throws IOException {
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            var tokens = scanner.nextLine().split(" ");
            var model = tokens[0];
            var power = tokens[1];
            switch (tokens.length) {
                case 2 -> engines.put(model, new Engine(model, power));
                case 3 -> engines.put(model, new Engine(model, power, tokens[2]));
                case 4 -> engines.put(model, new Engine(model, power, tokens[2], tokens[3]));
            }
        }
    }
}