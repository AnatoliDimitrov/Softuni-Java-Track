package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.ArrayList;
import java.util.Collection;

public class RegionImpl implements Region{
    @Override
    public String start(Collection<Magician> magicians) {
        Collection<Magician> wizards = new ArrayList<>();
        Collection<Magician> widows = new ArrayList<>();

        magicians.forEach(m -> {
            if (m.getClass().getSimpleName().equals("Wizard")){
                wizards.add(m);
            } else if(m.getClass().getSimpleName().equals("BlackWidow")){
                widows.add(m);
            }
        });

        var result = "";

        while (true){
            result = checkMagicians(wizards, widows);

            if (!result.equals("")){
                break;
            }

            for (var wizard:wizards) {
                for (var widow:widows) {
                    if (widow.isAlive() && wizard.getMagic().getBulletsCount() > 0){
                        widow.takeDamage(wizard.getMagic().fire());
                    }
                }
                result = checkMagicians(wizards, widows);

                if (!result.equals("")){
                    break;
                }
            }

            result = checkMagicians(wizards, widows);

            if (!result.equals("")){
                break;
            }

            for (var widow:widows) {
                for (var wizard:wizards) {
                    if (wizard.isAlive() && widow.getMagic().getBulletsCount() > 0){
                        wizard.takeDamage(widow.getMagic().fire());
                    }
                }
                result = checkMagicians(wizards, widows);

                if (!result.equals("")){
                    break;
                }
            }
            result = checkMagicians(wizards, widows);

            if (!result.equals("")){
                break;
            }
        }

        return result;
    }

    private String checkMagicians(Collection<Magician> wizards, Collection<Magician> widows){
        int wizardsHealth = wizards.stream().mapToInt(Magician::getHealth).sum();
        int widowsHealth = widows.stream().mapToInt(Magician::getHealth).sum();
        var result = "";
        if (widowsHealth <= 0){
            result = "Wizards win!";
        } else if (wizardsHealth <= 0) {
            result = "Black widows win!";
        }

        return result;
    }
}