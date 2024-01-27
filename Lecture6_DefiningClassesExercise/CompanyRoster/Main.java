package Lecture6_DefiningClassesExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    employees.add(employee);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                        employees.add(employee);
                    } else {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                        employees.add(employee);
                    }
                    break;
                default:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    employees.add(employee);
                    break;
            }
        }
        Map.Entry<String, List<Employee>> highestDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream().sorted((e1, e2) -> {
                    double e1avgSalary = e1.getValue().stream().mapToDouble(Employee::getSalary)
                            .average().getAsDouble();
                    double e2avgSalary = e2.getValue().stream().mapToDouble(Employee::getSalary)
                            .average().getAsDouble();
                    return Double.compare(e2avgSalary, e1avgSalary);
                      })
                    .findFirst().orElse(null);
        System.out.printf("Highest Average Salary: %s%n", highestDepartment.getKey());
        highestDepartment.getValue().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).forEach(System.out::println);
    }
}
