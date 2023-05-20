import java.net.NetworkInterface;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Robotics {
    private static Map<String, Integer> robots = new LinkedHashMap<>();
    private static Map<String, Integer> workingSeconds = new LinkedHashMap<>();
    private static ArrayDeque<String> products = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var robotsInfo = Arrays.stream(scanner.nextLine().split(";"));

        robotsInfo.forEach(r -> {
            var info = r.split("-");
            robots.put(info[0], Integer.parseInt(info[1]));
            workingSeconds.put(info[0], 0);
        });
        var stringTime = scanner.nextLine();

        if (stringTime.split(":")[0].length() < 2){
            stringTime = "0" + stringTime;
        }
        LocalTime time = LocalTime.parse(stringTime);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

        var product = scanner.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while(!products.isEmpty()){
            time = time.plusSeconds(1);
            var productStarted = false;
            for (var robot:workingSeconds.entrySet()) {
                if (robot.getValue() == 0){
                    System.out.printf("%s - %s [%s]\n", robot.getKey(), products.poll(), time.format(formatter));
                    robot.setValue(robots.get(robot.getKey()));
                    productStarted = true;
                    break;
                }
            }

            workingSeconds.forEach((r, t) -> {
                if (t > 0) workingSeconds.put(r, workingSeconds.get(r) - 1);
            });

            if (!productStarted && !products.isEmpty()){
                products.offer(products.poll());
            }
        }
    }
}
