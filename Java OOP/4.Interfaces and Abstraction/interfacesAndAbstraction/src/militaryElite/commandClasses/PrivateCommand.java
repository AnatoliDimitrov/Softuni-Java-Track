package militaryElite.commandClasses;

import militaryElite.factoryClasses.SoldierFactory;
import militaryElite.interfaces.Soldier;

import java.util.List;

public class PrivateCommand extends BaseCommand {

    public PrivateCommand(List<Soldier> soldiers) {

        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.producePrivate(args));
    }
}