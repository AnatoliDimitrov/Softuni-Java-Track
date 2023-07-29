package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.stream.Collectors;

public class MainService extends BaseService{
    public MainService(String name) {
        super(name, 30);
    }

}