package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    public SecondShift(String name) {
        super(name, 70);
    }

    @Override
    public void working() {
        var stren = this.getStrength() - 15;
        if (stren < 0){
            stren = 0;
        }
        this.setStrength(stren);
    }
}