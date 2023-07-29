package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.stream.Collectors;

public class SecondaryService extends BaseService{
    public SecondaryService(String name) {
        super(name, 15);
    }
}