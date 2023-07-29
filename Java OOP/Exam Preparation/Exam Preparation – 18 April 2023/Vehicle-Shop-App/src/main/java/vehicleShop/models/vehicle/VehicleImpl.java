package vehicleShop.models.vehicle;

import static vehicleShop.common.ExceptionMessages.*;

public class VehicleImpl implements Vehicle{

    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name){
        if (name == null || name.equals("")){
            throw new IllegalArgumentException(VEHICLE_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getStrengthRequired() {
        return this.strengthRequired;
    }

    private void setStrengthRequired(int strengthRequired){
        if (strengthRequired < 0){
            throw new IllegalArgumentException(VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }

        this.strengthRequired = strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.strengthRequired <= 0;
    }

    @Override
    public void making() {
        var stren = this.getStrengthRequired() - 5;
        if (stren < 0){
            stren = 0;
        }

        this.strengthRequired = stren;
    }
}