package magicGame.core;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic = null;
        
        if ("RedMagic".equals(type)) {
            magic = new RedMagic(name, bulletsCount);
        } else if ("BlackMagic".equals(type)) {
            magic = new BlackMagic(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }

        magics.addMagic(magic);

        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magician magician = null;
        Magic magic = magics.findByName(magicName);

        if (magic == null){
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        if ("Wizard".equals(type)) {
            magician = new Wizard(username, health, protection, magic);
        } else if ("BlackWidow".equals(type)) {
            magician = new BlackWidow(username, health, protection, magic);
        } else {
            throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }

        this.magicians.addMagician(magician);
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        var result = new StringBuilder();

        var sorted = magicians.getData()
                .stream()
                .sorted(
                        Comparator.comparingInt(Magician::getHealth)
                                .thenComparing(Magician::getUsername)
                                .thenComparing(m -> m.getClass().getSimpleName())
                ).collect(Collectors.toList());

        sorted.forEach(m -> {
            result.append(m);
            result.append(System.lineSeparator());
        });

        return result.toString().trim();
    }
}