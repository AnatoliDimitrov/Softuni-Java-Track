import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        String[] parentheses = scanner.nextLine().split("");

        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i].equals("(") || parentheses[i].equals("[") || parentheses[i].equals("{")){
                stack.push(parentheses[i]);
                continue;
            } else if(parentheses[i].equals(")") && !stack.isEmpty() && stack.pop().equals("(")){
                continue;
            } else if(parentheses[i].equals("}") && !stack.isEmpty() && stack.pop().equals("{")){
                continue;
            } else if(parentheses[i].equals("]") && !stack.isEmpty() && stack.pop().equals("[")){
                continue;
            }
            System.out.println("NO");
            return;
        }

        if (stack.size() == 0){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
