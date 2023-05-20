import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque();
        var commands = Integer.parseInt(scanner.nextLine());
        var input = "";

        for (int i = 0; i < commands; i++) {
            input = scanner.nextLine();

            if (input.startsWith("1")){
                stack.push(Arrays.stream(input.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray()[1]);
            } else if(input.startsWith("2")){
                stack.pop();
            } else {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
