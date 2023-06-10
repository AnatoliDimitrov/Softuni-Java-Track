package softUni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount(){
        return this.data.size();
    }

    public String insert(Student student){
        if (capacity == this.data.size()){
            return "The hall is full.";
        }
        if (this.data.contains(student)){
            return "Student is already in the hall.";
        }

        this.data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    public String remove(Student student){
        var removed = this.data.remove(student);
        if (removed){
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }

        return "Student not found.";
    }
    public Student getStudent(String firstName, String lastName){
        return this.data.stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();

        result.append("Hall size: " + this.data.size());

        this.data.forEach(s -> {
            result.append(System.lineSeparator());
            result.append(s.toString());
        });

        return result.toString();
    }
}