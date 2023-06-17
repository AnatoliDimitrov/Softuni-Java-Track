import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(toolsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(substancesStack::push);
        List<Integer> chalanges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

//        System.out.println(toolsQueue.poll());
//        System.out.println(substancesStack.pop());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && chalanges.size() > 0) {
            Integer sum = toolsQueue.peek() * substancesStack.peek();

            if (chalanges.contains(sum)) {
                toolsQueue.poll();
                substancesStack.pop();
                chalanges.remove(sum);
            } else {
                toolsQueue.offer(toolsQueue.poll() + 1);
                var substance = substancesStack.pop() - 1;
                if (substance > 0) {
                    substancesStack.push(substance);
                }
            }
        }

        if (chalanges.size() > 0) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!toolsQueue.isEmpty()) {
            System.out.println("Tools: " + toolsQueue.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }
        if (!substancesStack.isEmpty()){
            System.out.println("Substances: " + substancesStack.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }
        if (chalanges.size() > 0){
            System.out.println("Challenges: " + chalanges.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }
    }
}