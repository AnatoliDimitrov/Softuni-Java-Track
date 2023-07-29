package vehicleShop.models.tool;

import static vehicleShop.common.ExceptionMessages.*;

public class ToolImpl implements Tool{
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }

    private void setPower(int power){
        if (power < 0){
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }

        this.power = power;
    }

    @Override
    public void decreasesPower() {
        var pow = this.power - 5;
        if (pow < 0){
            pow = 0;
        }

        this.setPower(pow);
    }

    @Override
    public boolean isUnfit() {
        return this.power <= 0;
    }
}