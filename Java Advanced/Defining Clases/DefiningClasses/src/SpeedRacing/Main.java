package SpeedRacing;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();

        var carCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carCount; i++) {
            var carInfo = scanner.nextLine().split("\\s+");
            cars.put(carInfo[0], new Car(carInfo[0], Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2])));
        }

        var command = scanner.nextLine();

        while (!command.equals("End")){
            var info = command.split("\\s+");
            var car = info[1];
            var kilometers = Integer.parseInt(info[2]);
            var currentCar = cars.get(car);

            var canDrive = currentCar.drive(kilometers);
            if (!canDrive){
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }

        cars.values().forEach(c -> System.out.println(c.toString()));
    }
}