package vehicles;

import java.util.*;

public abstract class VehicleFactory {

    public static final Map<String, Vehicles> info = new LinkedHashMap<>();

    public static void create(String[] info) {

        switch (info[0]) {
            case "Car":
                VehicleFactory.info.put(info[0], new Car(Double.parseDouble(info[1]), Double.parseDouble(info[2])));
                break;
            case "Truck":
                VehicleFactory.info.put(info[0], new Truck(Double.parseDouble(info[1]), Double.parseDouble(info[2])));
                break;
        }
    }

    public static Map<String, Vehicles> getInfo() {
        return info;
    }
}