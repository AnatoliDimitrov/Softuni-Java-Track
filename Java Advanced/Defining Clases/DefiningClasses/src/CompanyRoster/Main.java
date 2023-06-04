package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Employee>> company = new HashMap<>();

        var count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            var info = scanner.nextLine().split("\\s+");
            var department = info[3];
            Employee employee = createEmployee(info);

            if (!company.containsKey(department)){
                company.put(department, new ArrayList<>());
            }

            company.get(department).add(employee);
        }

        var greatestSalaryDepartment = "";
        var greatest = 0.0;

        for (var entry : company.entrySet()) {

            var temp = entry
                    .getValue()
                    .stream()
                    .mapToDouble(e -> e.getSalary())
                    .average()
                    .getAsDouble();

            if (temp > greatest) {
                greatest = temp;
                greatestSalaryDepartment = entry.getKey();
            }
        }

        System.out.println("Highest Average Salary: " + greatestSalaryDepartment);
        var sorted = company
                .get(greatestSalaryDepartment)
                .stream()
                .sorted((a, b) -> b.getSalary().compareTo(a.getSalary()))
                .collect(Collectors.toList());

        for (var employee: sorted) {
            System.out.println(employee.toString());
        }
    }

    private static Employee createEmployee(String[] info) {
        Employee employee = null;
        var name = info[0];
        var salary = Double.parseDouble(info[1]);
        var position = info[2];
        var department = info[3];

        if (info.length == 4){
            employee = new Employee(name, salary, position, department);
        } else if (info.length == 5) {
            if (info[4].contains("@")) {
                employee = new Employee(name, salary, position, department, info[4]);
            } else {
                employee = new Employee(name, salary, position, department, Integer.parseInt(info[4]));
            }
        } else if (info.length == 6) {
            employee = new Employee(name, salary, position, department, info[4], Integer.parseInt(info[5]));
        }

        return employee;
    }
}