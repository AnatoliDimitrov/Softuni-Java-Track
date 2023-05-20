import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s");
        Integer toss = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> queue = new PriorityQueue(Arrays.asList(kids));
        var cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < toss; i++) {
                queue.offer(queue.poll());
            }
            if (checkPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean checkPrime(int n) {
        boolean flag = false;
        if(n == 1){
            return false;
        }
        for (int i = 2; i <= n / 2; ++i) {
            // condition for nonprime number
            if (n % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            return true;
        else
            return false;
    }
}
