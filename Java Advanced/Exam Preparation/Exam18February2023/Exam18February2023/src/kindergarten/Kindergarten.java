package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){
        if(this.registry.size() >= this.capacity){
            return false;
        }

        registry.add(child);
        return true;
    }

    public boolean removeChild(String firstName){
        Child child = this.registry.stream().filter(c -> c.getFirstName() == firstName).findFirst().orElse(null);
        if (child == null){
            return false;
        }
        this.registry.remove(child);
        return true;
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName){
        return this.registry.stream().filter(c -> c.getFirstName() == firstName).findFirst().orElse(null);
    }

    public String registryReport(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Registered children in %s:", this.name));
        var sorted = this.registry
                .stream()
                .sorted(Comparator.comparing(Child::getAge)
                        .thenComparing(Child::getFirstName)
                        .thenComparing(Child::getLastName, Comparator.reverseOrder()))
                .collect(Collectors.toList());


        for (var child:sorted) {
            result.append(System.lineSeparator());
            result.append("--");
            result.append(System.lineSeparator());
            result.append(child.toString());
        }

        return result.toString();
    }
}