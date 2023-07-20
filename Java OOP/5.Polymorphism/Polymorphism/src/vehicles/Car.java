package vehicles;

public class Car extends VehicleFunctionality {

    private static final double INCREASE_FUEL_PER_KM = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_PER_KM);
    }
}