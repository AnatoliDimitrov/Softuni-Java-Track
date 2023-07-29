package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl(){
        this.services = new ArrayList<>();
        this.supplements = new SupplementRepository();
    }
    @Override
    public String addService(String type, String name) {
        Service service = null;

        if ("MainService".equals(type)){
            service = new MainService(name);
        } else if ("SecondaryService".equals(type)) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }

        services.add(service);

        return String.format("%s is successfully added.", type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement sup = null;

        if ("PlasticArmor".equals(type)){
            sup = new PlasticArmor();
        } else if ("MetalArmor".equals(type)){
            sup = new MetalArmor();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplements.addSupplement(sup);

        return String.format("%s is successfully added.", type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        var supplement = supplements.findFirst(supplementType);
        if (supplement == null){
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Service service = services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);

        service.addSupplement(supplement);

        supplements.removeSupplement(supplement);

        return String.format("Successfully added %s to %s.", supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot = null;
        if ( "MaleRobot".equals(robotType)){
            robot = new MaleRobot(robotName, robotKind, price);
        } else if("FemaleRobot".equals(robotType)){
            robot = new FemaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        Service service = services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);

        if ("MaleRobot".equals(robotType) && service.getClass().getSimpleName().equals("MainService")){
            service.addRobot(robot);
            return String.format("Successfully added %s to %s.", robotType, serviceName);
        } else if ("FemaleRobot".equals(robotType) && service.getClass().getSimpleName().equals("SecondaryService")){
            service.addRobot(robot);
            return String.format("Successfully added %s to %s.", robotType, serviceName);
        } else {
            return UNSUITABLE_SERVICE;
        }
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);

        service.feeding();

        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
        var robots  = service.getRobots();
        var supplements = service.getSupplements();

        var robotsSum = robots.stream().mapToDouble(Robot::getPrice).sum();
        var supplementsSum = supplements.stream().mapToDouble(Supplement::getPrice).sum();

        return String.format("The value of service %s is %.2f.", serviceName, robotsSum + supplementsSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        for (var service:services) {
            result.append(service.getStatistics());
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }
}