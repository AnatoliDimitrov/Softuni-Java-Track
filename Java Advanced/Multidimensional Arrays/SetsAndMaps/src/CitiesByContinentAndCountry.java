import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        var counter = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < counter; i++) {
            var info = scanner.nextLine().split("\\s+");

            var continent = info[0];
            var country = info[1];
            var city = info[2];

            if (!continents.containsKey(continent)){
                continents.put(continent, new LinkedHashMap<>());
            }

            if (!continents.get(continent).containsKey(country)){
                continents.get(continent).put(country, new ArrayList<>());
            }

            continents.get(continent).get(country).add(city);
        }

        continents.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, cities) -> {
                System.out.print("  " + country + " -> ");
                System.out.println(String.join(", ", cities));
            });
        });
    }
}