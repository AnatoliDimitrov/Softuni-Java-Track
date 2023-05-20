import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        var input = "";

        while (!(input = scanner.nextLine()).equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
                continue;
            }

            System.out.println(input);
            stack.push(input);
        }
    }
}