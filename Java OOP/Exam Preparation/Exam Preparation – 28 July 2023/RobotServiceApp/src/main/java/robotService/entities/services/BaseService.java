package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public abstract class BaseService implements Service{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isBlank()){
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumHardness() {
        //return this.supplements.stream().mapToInt(Supplement::getHardness).sum();
        return 0;
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.robots.size() >= this.capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }

        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        this.robots.forEach(Robot::eating);
    }

    @Override
    public Collection<Robot> getRobots() {
        return Collections.unmodifiableCollection(robots);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(supplements);
    }


    @Override
    public String getStatistics() {
        var robotsStr = this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" "));
        if (this.getRobots().isEmpty()){
            robotsStr = "none";
        }
        String result = String.format("%s %s:", this.getName(), this.getClass().getSimpleName()) +
                System.lineSeparator() +
                String.format("Robots: %s", robotsStr) +
                System.lineSeparator() +
                String.format("Supplements: %s Hardness: %s", this.getSupplements().size(), this.getSupplements().stream().mapToInt(Supplement::getHardness).sum());
        return result;
    }
}