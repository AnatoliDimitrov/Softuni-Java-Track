package magicGame.repositories.interfaces;

import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static magicGame.common.ExceptionMessages.*;

public class MagicRepositoryImpl implements MagicRepository<Magic>{

    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null){
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }

        this.data.add(model);
    }
    @Override
    public Collection<Magic> getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return this.data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return this.data.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}