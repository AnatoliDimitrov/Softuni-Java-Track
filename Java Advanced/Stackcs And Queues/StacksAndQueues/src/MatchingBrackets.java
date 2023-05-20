import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        var problem = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < problem.length(); i++) {
            if(problem.charAt(i) == '('){
                stack.push(i);
            } else if(problem.charAt(i) == ')'){
                System.out.println(problem.substring(stack.pop(), i + 1));
            }
        }
    }
}
