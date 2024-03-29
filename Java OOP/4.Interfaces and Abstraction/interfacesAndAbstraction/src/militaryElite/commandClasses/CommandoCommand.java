package militaryElite.commandClasses;

import militaryElite.enumeration.Corps;
import militaryElite.factoryClasses.SoldierFactory;
import militaryElite.interfaces.Soldier;

import java.util.List;

public class CommandoCommand extends BaseCommand {
    public CommandoCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args)  {
        if (Corps.isValidCorps(args.get(4))) {
            super.add(SoldierFactory.produceCommando(args));
        }
    }
}