package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static magicGame.common.ExceptionMessages.*;

public class MagicianRepositoryImpl implements MagicianRepository<Magician>{

    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return this.data;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null){
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }

        this.data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return this.data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        return this.data.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
    }
}