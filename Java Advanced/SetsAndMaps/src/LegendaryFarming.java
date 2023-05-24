import java.security.KeyStore;
import java.util.*;

public class LegendaryFarming {
    private static String obtainedItem = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        List<String> keyMaterialsList = Arrays.asList("shards", "motes", "fragments");
        Map<String, String> items = new HashMap<>();
        items.put("shards", "Shadowmourne");
        items.put("fragments", "Valanyr");
        items.put("motes", "Dragonwrath");



        obtainLegendaryItem(scanner, keyMaterials, junkMaterials, keyMaterialsList, items);

        System.out.println(obtainedItem + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((c1, c2) -> keyMaterials.get(c2.getKey()).compareTo(keyMaterials.get(c1.getKey())))
                .forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        });

        junkMaterials.forEach((k, v) -> {
            System.out.printf("%s: %d%n", k, v);
        });
    }

    private static void obtainLegendaryItem(Scanner scanner, Map<String, Integer> keyMaterials, Map<String, Integer> junkMaterials, List<String> keyMaterialsList, Map<String, String> items) {
        var input = scanner.nextLine();
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("shards", 0);

        while (true) {
            var parts = input.split("\\s+");

            for (int i = 0; i < parts.length; i += 2) {
                if (!obtainedItem.equals("")){
                    return;
                }
                var quantity = Integer.parseInt(parts[i]);
                var material = parts[i + 1].toLowerCase();

                if (keyMaterialsList.contains(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, 0);
                    }
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }

                keyMaterials
                        .forEach((m, q) -> {
                    if (q >= 250){
                        obtainedItem = items.get(m);
                        keyMaterials.put(m, keyMaterials.get(m) - 250);
                    }
                });
            }
            if (!obtainedItem.equals("")){
                return;
            }

            input = scanner.nextLine();
        }
    }
}