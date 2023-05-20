import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextLine().split("\\s");


        for (var item:input) {
            stack.add(item);
        }
        var result = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            var element = stack.pop();
            var sign = false;
            if (element.equals("+")){
                result += Integer.parseInt(stack.pop());
            } else if (element.equals("-")) {
                result -= Integer.parseInt(stack.pop());
            }
        }

        System.out.println(result);
    }
}
