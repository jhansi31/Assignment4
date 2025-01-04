package org.example;

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Reference of the base class pointing to objects of derived classes
        animal myanimal;

        // Runtime polymorphism: Dog object
        myanimal = new Dog();
        myanimal.sound();

        // Runtime polymorphism: Cat object
        myanimal = new Cat();
        myanimal.sound();

        // Using base class reference to call base class method
        myanimal = new animal();
        myanimal.sound();
    }
}