package vehicles;

public class Truck extends VehicleFunctionality {

    private static final double INCREASE_FUEL_PER_KM = 1.6;
    private static final double REDUCE_REFUEL = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_PER_KM);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REDUCE_REFUEL);
    }
}