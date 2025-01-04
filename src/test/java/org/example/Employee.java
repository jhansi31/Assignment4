package org.example;

abstract class Employee {
    private String name;
    private int employeeId;

    // Constructor
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Concrete method (common behavior)
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId + ", Name: " + name);
    }

    // Abstract method (specific behavior to be defined by subclasses)
    public abstract double calculateSalary();
}
