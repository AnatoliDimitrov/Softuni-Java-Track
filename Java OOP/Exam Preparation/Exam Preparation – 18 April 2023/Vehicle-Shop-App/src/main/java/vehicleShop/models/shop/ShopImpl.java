package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop{
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        while (worker.canWork() && !vehicle.reached()){
            Tool currentTool = worker.getTools().stream().filter(t -> !t.isUnfit()).findFirst().orElse(null);
            if (currentTool == null){
                break;
            }

            vehicle.making();
            worker.working();
            currentTool.decreasesPower();
        }
    }
}