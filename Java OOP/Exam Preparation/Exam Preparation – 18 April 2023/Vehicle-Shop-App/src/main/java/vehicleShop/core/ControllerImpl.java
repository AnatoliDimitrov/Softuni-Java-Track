package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private WorkerRepository workers;
    private VehicleRepository vehicles;
    private int readyVehicles;

    public ControllerImpl() {
        this.workers = new WorkerRepository();
        this.vehicles = new VehicleRepository();
        readyVehicles = 0;
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker = null;
        if ("FirstShift".equals(type)){
            worker = new FirstShift(workerName);
        } else if ("SecondShift".equals(type)){
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }

        this.workers.add(worker);

        return String.format(ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);

        vehicles.add(vehicle);

        return String.format(SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = workers.findByName(workerName);
        if (worker == null){
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Tool tool = new ToolImpl(power);
        worker.addTool(tool);

        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        int totalUnfitTools = 0;
        var fitWorkers = workers.getWorkers().stream().filter(w -> w.getStrength() > 70).toArray();

        if (fitWorkers.length <= 0){
            throw new IllegalArgumentException(NO_WORKER_READY);
        }

        Vehicle vehicle = vehicles.findByName(vehicleName);

        Shop shop = new ShopImpl();
        for (var worker : fitWorkers) {
            shop.make(vehicle, (Worker) worker);
            if (vehicle.reached()){
                break;
            }
        }
        var done = "not done";
        if (vehicle.reached()){
            readyVehicles++;
            done = "done";
        }

        for (var worker : fitWorkers) {
            var unfitTools = ((Worker) worker).getTools().stream().filter(Tool::isUnfit).toArray();

            totalUnfitTools += unfitTools .length;
        }

        return String.format(VEHICLE_DONE, vehicleName, done) + String.format(COUNT_BROKEN_INSTRUMENTS, totalUnfitTools);
    }

    @Override
    public String statistics() {
        var result = new StringBuilder();
        result.append(String.format("%d vehicles are ready!", readyVehicles));
        result.append(System.lineSeparator());
        result.append("Info for workers:");
        workers.getWorkers().forEach(w -> {
            result.append(System.lineSeparator());
            result.append(String.format("Name: %s, Strength: %d", w.getName(), w.getStrength()));
            var fitTools = w.getTools().stream().filter(t -> !t.isUnfit()).toArray();
            result.append(System.lineSeparator());
            result.append(String.format("Tools: %d fit left", fitTools.length));
        });

        return result.toString();
    }
}