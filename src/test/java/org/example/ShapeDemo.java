package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShapeDemo {
    public static void main(String[] args) {
        // Create a list of shapes
        List<Shape> shapes = new ArrayList<>();

        // Add different shapes to the list
        shapes.add(new Circle(5.0));            // Circle with radius 5
        shapes.add(new Rectangle(4.0, 6.0));   // Rectangle with length 4 and width 6
        shapes.add(new Triangle(3.0, 7.0));    // Triangle with base 3 and height 7

        // Calculate and display the area of each shape
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
        }
    }
}