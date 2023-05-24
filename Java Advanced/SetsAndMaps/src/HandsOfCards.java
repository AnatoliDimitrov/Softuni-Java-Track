import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        Map<String, Integer> powers = new HashMap<>();
        Map<String, Integer> types = new HashMap<>();

        powers.put("2", 2);
        powers.put("3", 3);
        powers.put("4", 4);
        powers.put("5", 5);
        powers.put("6", 6);
        powers.put("7", 7);
        powers.put("8", 8);
        powers.put("9", 9);
        powers.put("10", 10);
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);

        types.put("S", 4);
        types.put("H", 3);
        types.put("D", 2);
        types.put("C", 1);

        var input = scanner.nextLine();

        while (!input.equals("JOKER")){
            var draw = input.split(": ");

            var name = draw[0];
            var cards = Arrays.stream(draw[1].split(", ")).collect(Collectors.toSet());
            if (!players.containsKey(name)){
                players.put(name, cards);
            } else {
                players.get(name).addAll(cards);
            }


            input = scanner.nextLine();
        }

        players.forEach((p, c) -> {
            var sum = 0;

            for (var card: c){
                var power = card.substring(0, card.length() - 1);
                var type = card.substring(card.length() -1, card.length());
                sum += powers.get(power) * types.get(type);
            }

            System.out.printf("%s: %d%n", p, sum);
        });
    }
}