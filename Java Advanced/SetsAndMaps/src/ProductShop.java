import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        var input = scanner.nextLine();

        while (!input.equals("Revision")){
            var info = input.split(", ");
            var shop = info[0];
            var product = info[1];
            var price = Double.parseDouble(info[2]);

            if (!shops.containsKey(shop)){
                shops.put(shop, new LinkedHashMap<>());
            }

            shops.get(shop).put(product, price);

            input = scanner.nextLine();
        }

       shops.forEach((k, v) -> {
           System.out.printf("%s->\n", k);
           shops.get(k).forEach((product, price) -> {
               System.out.printf("Product: %s, Price: %.1f\n", product, price);
           });
       });
    }
}