package CompanyRoster;

public class Employee {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, Double salary, String position, String department, String email, int age) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.setAge(age);
        this.setEmail(email);
    }

    public Employee(String name, Double salary, String position, String department) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.setAge(-1);
        this.setEmail("n/a");
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.setEmail(email);
    }

    public Employee(String name, Double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.setAge(age);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}