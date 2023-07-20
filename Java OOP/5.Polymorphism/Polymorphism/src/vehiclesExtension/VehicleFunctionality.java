package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleFunctionality implements Vehicles {

    protected double fuelQuantity;
    protected double fuelConsumption;
    protected final double tankCapacity;

    protected VehicleFunctionality(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public static void execute(String[] info) {

        switch (info[0]) {
            case "Drive":
                VehicleFactory.getInfo().get(info[1]).drive(Double.parseDouble(info[2]));
                break;
            case "Refuel":
                VehicleFactory.getInfo().get(info[1]).refuel(Double.parseDouble(info[2]));
                break;
            case "DriveEmpty":
                VehicleFactory.getInfo().get(info[1]).drive(Double.parseDouble(info[2]), Bus.getDecreasedFuelPerKm());

                break;
        }
    }

    @Override
    public void drive(double distance, double decrease) {
        this.setFuelConsumption(decrease);
        this.drive(distance);
        this.setFuelConsumption(Bus.getIncreasedFuelPerKm());
    }

    @Override
    public void drive(double distance) {
        double neededLiters = distance * this.getFuelConsumption();
        DecimalFormat format = new DecimalFormat("###.##");
        if (neededLiters <= this.getFuelQuantity()) {
            setFuelQuantity(-neededLiters);
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), format.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (getFuelQuantity() + liters > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.setFuelQuantity(liters);
        }
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity += fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption += fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}