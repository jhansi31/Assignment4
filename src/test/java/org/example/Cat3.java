package org.example;

class Cat3 implements Animal3 {
    @Override
    public void makeSound() {
        System.out.println("The cat says: Meow Meow");
    }

    @Override
    public void eat() {
        System.out.println("The cat drinks milk.");
    }
}


