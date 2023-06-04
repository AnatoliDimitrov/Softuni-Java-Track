package magazine;

import java.util.ArrayList;
import java.util.List;

public class Magazine {
    private List<Cloth> data;
    private String type;
    private  int capacity;

    public Magazine(String type, int capacity) {
        this.setType(type);
        this.setCapacity(capacity);
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addCloth(Cloth cloth){
        if (this.data.size() < this.capacity){
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color){
        //data = data.stream().filter(c -> !c.getColor().equals(color)).collect(Collectors.toList());
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getColor().equals(color)){
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Cloth getSmallestCloth(){
        var index = -1;
        var size = Integer.MAX_VALUE;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSize() < size){
                size = data.get(i).getSize();
                index = i;
            }
        }
        return data.get(index);
    }
    public Cloth getCloth(String color){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getColor().equals(color)){
                return data.get(i);
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String report(){
//        var res = new StringBuilder();
//        res.append(String.format("%s magazine contains:%n", this.getType()));
        var result = String.format("%s magazine contains:", this.getType());
        for (int i = 0; i < data.size(); i++) {
            result += System.lineSeparator();
            result += data.get(i).toString();
           // res.append(String.format("%s%n", data.get(i).toString()));
        }
        return result;
    }
}