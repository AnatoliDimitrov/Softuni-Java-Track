import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s");
        Integer toss = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque(Arrays.asList(kids));

        while (queue.size() > 1) {
            for (int i = 1; i < toss; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
