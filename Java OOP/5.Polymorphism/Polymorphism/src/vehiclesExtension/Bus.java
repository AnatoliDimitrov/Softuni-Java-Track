package vehiclesExtension;

public class Bus extends VehicleFunctionality{

    private static final double INCREASED_FUEL_PER_KM = 1.4;
    private static final double DECREASED_FUEL_PER_KM = -1.4;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + INCREASED_FUEL_PER_KM, tankCapacity);
    }

    public static double getIncreasedFuelPerKm() {
        return INCREASED_FUEL_PER_KM;
    }

    public static double getDecreasedFuelPerKm() {
        return DECREASED_FUEL_PER_KM;
    }
}