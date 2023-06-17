package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if (this.vehicles.size() < this.capacity){
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin){
        return this.vehicles.removeIf(v -> v.getVIN().equals(vin));
    }

    public int getCount(){
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage(){
        return this.vehicles.stream().min(Comparator.comparingInt(Vehicle::getMileage)).orElse(null);
    }

    public String report(){
        var result = new StringBuilder();

        result.append("Vehicles in the preparatory:");

        for (var vehicle : this.vehicles) {
            result.append(System.lineSeparator());
            result.append(vehicle.toString());
        }

        return result.toString();
    }
}