package magicGame.models.magicians;

import magicGame.models.magics.Magic;
import magicGame.models.magics.MagicImpl;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician{

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
        this.isAlive = true;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username){
        if (username == null || username.trim().isBlank()){
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }

        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health){
        if (health < 0){
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }

        this.health = health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    private void setProtection(int protection){
        if (protection < 0){
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }

        this.protection = protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    private void setMagic(Magic magic){
        if (magic == null){
            throw new NullPointerException(INVALID_MAGIC);
        }

        this.magic = magic;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (this.protection > 0){
            var currentPoints = points;
            points -= this.protection;
            protection -= currentPoints;
            if (protection > 0){
                return;
            }
        }
        if (points > 0){
            if (this.health > 0){
                this.health -= points;
            }
        }
        if (health <= 0){
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        var result = new StringBuilder();

        result.append(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()));
        result.append(System.lineSeparator());
        result.append(String.format("Health: %d", this.getHealth()));
        result.append(System.lineSeparator());
        result.append(String.format("Protection: %d", this.getProtection()));
        result.append(System.lineSeparator());
        result.append(String.format("Magic: %s", this.getMagic().getName()));

        return result.toString().trim();
    }
}