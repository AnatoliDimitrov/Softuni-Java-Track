package RawData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);
    static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        getCars();

        String cargoType = reader.nextLine();

        switch (cargoType) {
            case "fragile" -> cars.stream()
                    .filter(car -> car.getCargoType().equals("fragile"))
                    .filter(Car::isValidTierPressure)
                    .forEach(System.out::println);
            case "flamable" -> cars.stream()
                    .filter(car -> car.getCargoType().equals("flamable"))
                    .filter(Car::isValidEnginePower)
                    .forEach(System.out::println);
        }

    }

    private static void getCars() throws IOException {
        int carsNumber = Integer.parseInt(reader.nextLine());
        while (carsNumber-- > 0) {
            String[] info = reader.nextLine().split(" ");
            cars.add(new Car(info));
        }
    }
}