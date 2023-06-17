import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var matches = 0;

        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(malesStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femalesQueue::offer);

//        System.out.println(femalesQueue.poll());
//        System.out.println(malesStack.pop());
        while (!femalesQueue.isEmpty() && !malesStack.isEmpty()) {
            var male = malesStack.peek();
            var female = femalesQueue.peek();

            if (male <= 0 || female <= 0) {
                if (male <= 0) {
                    malesStack.pop();
                }
                if (female <= 0) {
                    femalesQueue.poll();
                }
                continue;
            }

            if (male % 25 == 0 || female % 25 == 0) {
                if (male % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                }
                if (female % 25 == 0) {
                    femalesQueue.poll();
                    femalesQueue.poll();
                }
                continue;
            }

            if (male == female) {
                matches++;
                femalesQueue.poll();
                malesStack.pop();
            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }
        }

        System.out.println("Matches: " + matches);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + malesStack.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + femalesQueue.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }
    }
}