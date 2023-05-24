import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesPopulation = new LinkedHashMap<>();

        var input = scanner.nextLine();

        while (!input.equals("report")) {
            var info = input.split("[|]");
            var city = info[0];
            var country = info[1];
            var population = Long.parseLong(info[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countriesPopulation.put(country, 0L);
            }

            countriesPopulation.put(country, countriesPopulation.get(country) + population);
            countries.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> countriesPopulation.get(c2.getKey()).compareTo(countriesPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)\n", country.getKey(), countriesPopulation.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(city -> {
                                System.out.format("=>%s: %d\n", city.getKey(), city.getValue());
                            });
                });
    }
}