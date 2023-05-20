import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var memory = new ArrayDeque<String>();
        
        var text = "";
        var commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands; i++) {
            var input = scanner.nextLine();
            String[] arr = new String[2];
            var command = "";
            if(input.equals("4")){
                command = input;
            } else{
                arr = input.split(" ");
                command = arr[0];
            }


            if (command.equals("1")){
                memory.push(text);
                text += arr[1];
            } else if (command.equals("2")) {
                memory.push(text);
                text = text.substring(0, text.length() - Integer.parseInt(arr[1]));
            } else if (command.equals("3")) {
                System.out.println(text.charAt(Integer.parseInt(arr[1]) - 1));
            } else if (command.equals("4")) {

                text = memory.pop();
            }
        }
    }
}
