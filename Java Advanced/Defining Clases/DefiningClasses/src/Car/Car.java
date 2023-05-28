package Car;

public class Car {

    private String brand;
    private String model;
    private Integer horsePower;

    public Car(String brand) {
        this.setBrand(brand);
        this.setModel("unknown");
        this.setHorsePower(-1);
    }

    public Car(String brand, String model, Integer horsePower) {
        this(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}