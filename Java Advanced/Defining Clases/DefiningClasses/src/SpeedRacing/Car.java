package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForKm;
    private int distance = 0;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
    }

    public boolean drive(int kilometers){
        if (canDrive(kilometers)){
            move(kilometers);
            return true;
        }

        return false;
    }

    private void move(int kilometers) {
        this.fuelAmount -= this.fuelCostForKm * kilometers;
        this.distance += kilometers;
    }

    private boolean canDrive(int kilometers) {
        var fuelNeeded = this.fuelCostForKm * kilometers;
        if(fuelNeeded > fuelAmount){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}