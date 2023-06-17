package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {

        return this.data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
//        var car = this.data
//                .stream()
//                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
//                .findFirst()
//                .orElse(null);
//
//        if (car == null) {
//            return false;
//        }
//
//        this.data.remove(car);
//        return true;
    }

    public Car getLatestCar() {
        return this.data
                .stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data
                .stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        var result = new StringBuilder();

        result.append(String.format("The cars are parked in %s:", this.type));

        for (var car :this.data) {
            result.append(System.lineSeparator());
            result.append(car.toString());
        }

        return result.toString();
    }
}
