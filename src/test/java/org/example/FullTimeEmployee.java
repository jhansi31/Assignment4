package org.example;

class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, int employeeId, double annualSalary) {
        super(name, employeeId);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateSalary() {
        return annualSalary / 12; // Monthly salary
    }
}