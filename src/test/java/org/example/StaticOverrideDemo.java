package org.example;

public class StaticOverrideDemo {
    public static void main(String[] args) {
        // Reference of Parent pointing to an object of Child
        Parent obj = new Child();

        // Static method call - Resolved at compile time
        obj.display(); // Calls Parent's static method

        // Instance method call - Resolved at runtime
        obj.instanceMethod(); // Calls Child's instance method
    }
}