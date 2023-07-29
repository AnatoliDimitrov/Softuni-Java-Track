package robotService.entities.robot;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {
    private String name;
    private String kind;
    private int kilograms;
    private double price;

    public BaseRobot(String name, String kind, int kilograms, double price) {
        this.setName(name);
        this.setKind(kind);
        this.kilograms = kilograms;
        this.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new NullPointerException(ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setKind(String kind) {
        if (kind == null || kind.trim().isBlank()) {
            throw new NullPointerException(ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.kind = kind;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.price = price;
    }

    public int getKilograms() {
        return this.kilograms;
    }

    public double getPrice() {
        return this.price;
    }

    public void eating() {
        if (this.getClass().getSimpleName().equals("FemaleRobot")) {
            this.kilograms++;
        } else {
            this.kilograms += 3;
        }
    }
}