package CatLady;

public abstract class Cat {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}