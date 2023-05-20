import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        var input = "";

        while (!(input = scanner.nextLine()).equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forward.push(stack.pop());
                    System.out.println(stack.peek());
                }
                continue;
            }
            if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peek());
                    stack.push(forward.pop());
                }
                continue;
            }

            System.out.println(input);
            stack.push(input);
            forward.clear();
        }
    }
}
