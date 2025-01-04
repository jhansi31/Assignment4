package org.example;

class Car implements Vehicle, Machine {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }

    @Override
    public void operate() {
        System.out.println("Car is operating as a machine.");
    }
}
