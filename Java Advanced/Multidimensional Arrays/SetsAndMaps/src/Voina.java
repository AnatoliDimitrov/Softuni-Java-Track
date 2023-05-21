import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        var counter = 0;

        for (int i = 0; i < 50; i++) {
            if(firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()){
                break;
            }
            int firstNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstNumber);

            int secondNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondNumber);

            if(firstNumber > secondNumber){
                firstPlayerCards.add(firstNumber);
                firstPlayerCards.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayerCards.add(firstNumber);
                secondPlayerCards.add(secondNumber);
            }
        }

        if(firstPlayerCards.size() > secondPlayerCards.size()){
            System.out.println("First player win!");
        } else if (secondPlayerCards.size() > firstPlayerCards.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }
}