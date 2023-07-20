package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleFunctionality implements Vehicles {

    protected double fuelQuantity;
    protected double fuelConsumption;

    protected VehicleFunctionality(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public static void execute(String[] info) {

        switch (info[0]) {
            case "Drive":
                VehicleFactory.getInfo().get(info[1]).drive(Double.parseDouble(info[2]));
                break;
            case"Refuel":
                VehicleFactory.getInfo().get(info[1]).refuel(Double.parseDouble(info[2]));
                break;
        }
    }

    @Override
    public void drive(double distance) {
        double neededLiters = distance * getFuelConsumption();
        DecimalFormat format = new DecimalFormat("###.##");
        if (neededLiters <= getFuelQuantity()) {
            setFuelQuantity(-neededLiters);
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), format.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}