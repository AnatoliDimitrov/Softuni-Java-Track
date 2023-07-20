package vehiclesExtension;

import java.util.*;

public abstract class VehicleFactory {

    public static final Map<String, Vehicles> info = new LinkedHashMap<>();

    public static void create(String[] info) {

        double fuelQuantity = Double.parseDouble(info[1]);
        double fuelConsumption = Double.parseDouble(info[2]);
        double tankCapacity = Double.parseDouble(info[3]);

        switch (info[0]) {
            case "Car":
                VehicleFactory.info.put(info[0],new Car(fuelQuantity,fuelConsumption,tankCapacity));
                break;
            case "Truck":
                VehicleFactory.info.put(info[0], new Truck(fuelQuantity,fuelConsumption,tankCapacity));
                break;
            case "Bus":
                VehicleFactory.info.put(info[0], new Bus(fuelQuantity,fuelConsumption,tankCapacity));
                break;
        }
    }

    public static Map<String, Vehicles> getInfo() {
        return info;
    }
}