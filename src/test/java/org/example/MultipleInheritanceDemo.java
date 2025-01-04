package org.example;

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        // Create an object of the Car class
        Car myCar = new Car();

        // Call methods from both interfaces
        myCar.start();
        myCar.operate();
    }
}