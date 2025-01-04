package org.example;

abstract class Animal2 {
    // Abstract method (no implementation)
    abstract void makeSound();

    // Concrete method
    void eat() {
        System.out.println("This animal eats food.");
    }
}