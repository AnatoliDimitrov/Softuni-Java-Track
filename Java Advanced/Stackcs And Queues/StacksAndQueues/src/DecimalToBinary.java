import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        var number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque();

        if (number == 0){
            System.out.println(number);
        } else {
            while (number != 0){
                stack.push(number % 2);
                number /= 2;
            }
        }
        var len = stack.size();
        for (int i = 0; i < len ; i++) {
            System.out.print(stack.pop());
        }
    }
}
