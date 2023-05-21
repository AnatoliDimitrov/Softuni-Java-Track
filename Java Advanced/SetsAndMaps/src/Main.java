import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> plates = new LinkedHashSet<>();

        var input = scanner.nextLine();

        while(!input.equals("END")){
            var info = input.split(", ");

            var command = info[0];
            var plate = info[1];

            if(command.equals("IN")) {
                plates.add(plate);
            } else {
                plates.remove(plate);
            }

            input = scanner.nextLine();
        }

        if(plates.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join("\n", plates));
        }
    }
}