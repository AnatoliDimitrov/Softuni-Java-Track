import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasickQueueOperations {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
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
            queue.offer(elements[i]);
        }

        while(countToPop > 0 && !queue.isEmpty()){
            queue.poll();
            countToPop--;
        }

        if (queue.isEmpty()){
            System.out.println(0);
        } else if(queue.contains(present)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
