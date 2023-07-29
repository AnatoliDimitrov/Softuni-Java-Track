package magicGame.models.magics;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicImpl implements Magic{

    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name){
        if (name == null || name.trim().isBlank()){
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }

        this.name = name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    protected void setBulletsCount(int bullets){
        if (bullets < 0){
            throw new IllegalArgumentException(INVALID_MAGIC_BULLETS_COUNT);
        }

        this.bulletsCount = bullets;
    }

//    @Override
//    public int fire() {
//        return 0;
//    }
}