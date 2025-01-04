package org.example;
public class AbstractionWithInterfaceDemo {
    public static void main(String[] args) {
        // Reference of Animal interface pointing to Dog object
        Animal3 dog = new Dog3();
        dog.makeSound();
        dog.eat();

        // Reference of Animal interface pointing to Cat object
        Animal3 cat = new Cat3();
        cat.makeSound();
        cat.eat();
    }
}

