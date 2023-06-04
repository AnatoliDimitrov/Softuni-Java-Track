import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textileQueue = new ArrayDeque<>();
        Deque<Integer> medicamentStack = new ArrayDeque<>();

        Map<String, Integer> items = new TreeMap<>();
        items.put("Patch", 0);
        items.put("Bandage", 0);
        items.put("MedKit", 0);

        var textiles = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (var textile: textiles) {
            textileQueue.offer(textile);
        }

        var medicaments = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (var medicament: medicaments) {
            medicamentStack.push(medicament);
        }

        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()){
            var textile = textileQueue.poll();
            var medicament = medicamentStack.pop();
            var sum = textile + medicament;

            if (sum == 30){
                items.put("Patch", items.get("Patch") + 1);
            } else if (sum == 40) {
                items.put("Bandage", items.get("Bandage") + 1);
            } else if ( sum == 100) {
                items.put("MedKit", items.get("MedKit") + 1);
            } else if (sum > 100) {
                items.put("MedKit", items.get("MedKit") + 1);
                sum -= 100;
                medicamentStack.push(medicamentStack.pop() + sum);
            } else {
                medicamentStack.push(medicament + 10);
            }
        }

        if (textileQueue.isEmpty() && medicamentStack.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        items.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(e -> {
            if (e.getValue() > 0) {
                System.out.println(e.getKey() + " - " + e.getValue());
            }
        });

        if (!textileQueue.isEmpty()) {
            System.out.println("Textiles left: " + textileQueue.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        } else if (!medicamentStack.isEmpty()) {
            System.out.println("Medicaments left: " + medicamentStack.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }
    }
}