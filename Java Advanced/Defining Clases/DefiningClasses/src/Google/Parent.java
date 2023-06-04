package Google;

public class Parent {
    private final String name;
    private final String dateOfBirth;

    public Parent(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.dateOfBirth);
    }
}