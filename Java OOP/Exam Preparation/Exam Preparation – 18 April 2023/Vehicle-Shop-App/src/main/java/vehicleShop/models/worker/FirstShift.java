package vehicleShop.models.worker;

public class FirstShift extends BaseWorker{
    public FirstShift(String name) {
        super(name, 100);
    }

    @Override
    public void working() {
        var stren = this.getStrength() - 10;
        if (stren < 0){
            stren = 0;
        }
        this.setStrength(stren);
    }
}