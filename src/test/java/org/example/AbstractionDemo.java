package org.example;

public class AbstractionDemo {
    public static void main(String[] args) {
        // Create Dog object and call its methods
        Animal2 dog = new Dog2();
        dog.makeSound();
        dog.eat();

        // Create Cat object and call its methods
        Animal2 cat = new Cat2();
        cat.makeSound();
        cat.eat();
    }
}