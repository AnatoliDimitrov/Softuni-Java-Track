import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int days = 0;

        List<Integer> garden = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while(true){
            boolean deadPlants = false;
            for (int i = garden.size() - 1; i > 0; i--) {
                if (garden.get(i) > garden.get(i - 1)){
                    garden.remove(i);
                    deadPlants = true;
                }
            }

            if (deadPlants == false){
                break;
            }

            days++;
        }

        System.out.println(days);
    }
}
