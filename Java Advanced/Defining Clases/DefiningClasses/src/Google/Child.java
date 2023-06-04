package Google;

public class Child {
    private final String name;
    private final String dateOfBirth;

    public Child(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.dateOfBirth);
    }
}