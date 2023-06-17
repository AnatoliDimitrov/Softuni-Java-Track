package parking;

public class Car {
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, Integer year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return ye ar;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.getManufacturer(), this.getModel(), this.getYear());
    }
}
