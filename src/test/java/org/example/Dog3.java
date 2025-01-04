package org.example;

public class Dog3  implements Animal3 {
    @Override
    public void makeSound() {
        System.out.println("The dog says: Woof Woof");
    }

    @Override
    public void eat() {
        System.out.println("The dog eats bones.");
    }
}
