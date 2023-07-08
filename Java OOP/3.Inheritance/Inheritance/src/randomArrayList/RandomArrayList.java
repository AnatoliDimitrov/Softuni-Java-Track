package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private final Random random = new Random();

    public RandomArrayList(){
        super();
    }
    public T getRandomElement(){
        return this.get(random.nextInt(super.size()));
    }
}