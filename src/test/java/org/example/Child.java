package org.example;

class Child extends Parent {
    // Static method in the child class
    static void display() {
        System.out.println("Static method in Child class.");
    }

    // Overriding the instance method
    @Override
    void instanceMethod() {
        System.out.println("Instance method in Child class.");
    }
}