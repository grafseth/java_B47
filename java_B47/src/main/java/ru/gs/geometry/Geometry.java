package ru.gs.geometry;

import ru.gs.geometry.figures.Rectangle;
import ru.gs.geometry.figures.Square;
import ru.gs.geometry.figures.Triangle;


public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));
        
        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);

        Triangle.printTriangleArea(new Triangle(3.0,5.0,7.0));
        Triangle.printTrianglePerimeter(new Triangle(3.0,5.0,5.0));
     }

}

