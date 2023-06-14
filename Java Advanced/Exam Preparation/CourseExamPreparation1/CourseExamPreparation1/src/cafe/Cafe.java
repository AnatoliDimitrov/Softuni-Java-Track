package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if(this.employees.size() < this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        var emp = this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);

        if (emp == null){
            return false;
        }

        this.employees.remove(emp);
        return true;
    }

    public Employee getOldestEmployee(){
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name){
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        var result = new StringBuilder();

        result.append(String.format("Employees working at Cafe %s:", this.name));

        for (var emp: this.employees) {
            result.append(System.lineSeparator());
            result.append(emp.toString());
        }

        return result.toString();
    }
}