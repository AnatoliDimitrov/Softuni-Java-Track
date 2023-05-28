package magazine;

public class Cloth {
    private String color;
    private int size;
    private String type;

    public Cloth(String color, int size, String type) {
        this.setColor(color);
        this.setSize(size);
        this.setType(type);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Product: %s with size %d, color %s", this.getType(), this.getSize(), this.getColor());
    }
}