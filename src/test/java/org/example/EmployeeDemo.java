package org.example;

public class EmployeeDemo {
    public static void main(String[] args) {
        // Create a full-time employee
        Employee fullTime = new FullTimeEmployee("Alice", 101, 60000.0);
        fullTime.displayDetails();
        System.out.println("Monthly Salary: $" + fullTime.calculateSalary());

        // Create a part-time employee
        Employee partTime = new PartTimeEmployee("Bob", 102, 20.0, 80); // $20/hour for 80 hours
        partTime.displayDetails();
        System.out.println("Monthly Salary: $" + partTime.calculateSalary());
    }
}