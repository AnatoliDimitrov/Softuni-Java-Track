import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        int[] instructions = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countToPush = instructions[0];
        int countToPop = instructions[1];
        int present = instructions[2];

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < countToPush; i++) {
            stack.push(elements[i]);
        }

        while(countToPop > 0 && !stack.isEmpty()){
            stack.pop();
            countToPop--;
        }

        if (stack.isEmpty()){
            System.out.println(0);
        } else if(stack.contains(present)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
