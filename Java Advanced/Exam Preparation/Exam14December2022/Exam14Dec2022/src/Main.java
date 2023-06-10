import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> staminaQueue = new ArrayDeque<>();
        Deque<Integer> foodStack = new ArrayDeque<>();
        Deque<String> peeksQueue = new ArrayDeque<>();
        Deque<Integer> levelsQueue = new ArrayDeque<>();
        Deque<String> conquerdQueue = new ArrayDeque<>();

        peeksQueue.offer("Vihren");
        peeksQueue.offer("Kutelo");
        peeksQueue.offer("Banski Suhodol");
        peeksQueue.offer("Polezhan");
        peeksQueue.offer("Kamenitza");

        levelsQueue.offer(80);
        levelsQueue.offer(90);
        levelsQueue.offer(100);
        levelsQueue.offer(60);
        levelsQueue.offer(70);

        var food = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (var textile: food) {
            staminaQueue.push(textile);
        }

        var stamina = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (var medicament: stamina) {
            foodStack.offer(medicament);
        }

        while (!foodStack.isEmpty() && !staminaQueue.isEmpty() && conquerdQueue.size() < 5){
            var sum = foodStack.poll() + staminaQueue.pop();

            var level = levelsQueue.peek();

            if(sum >= level){
                conquerdQueue.offer(peeksQueue.poll());
                levelsQueue.poll();
            }
        }

        if (conquerdQueue.size() == 5){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if(conquerdQueue.size() > 0){
            System.out.println("Conquered peaks:");
            System.out.println(conquerdQueue.stream().map(e -> e + "").collect(Collectors.joining(System.lineSeparator())));
        }
    }
}