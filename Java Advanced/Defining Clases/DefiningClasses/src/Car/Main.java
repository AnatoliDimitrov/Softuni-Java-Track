package Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            var carInfo = scanner.nextLine().split("\\s+");
            Car car = null;
            if (carInfo.length == 1){
                car = new Car(carInfo[0]);
            } else if (carInfo.length == 3) {
                car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
            }

            System.out.println(car);
        }
    }
}