package ru.gs.geometry;

import ru.gs.geometry.figures.Rectangle;
import ru.gs.geometry.figures.Square;
import ru.gs.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;


public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(7.0), new Square(5.0),new Square(3.0));
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }
        Consumer<Square> print = Square::printSquareArea;
        squares.forEach(print);


//        Rectangle.printRectangleArea(3.0, 5.0);
//        Rectangle.printRectangleArea(7.0, 9.0);
//
//        Triangle.printTriangleArea(new Triangle(3.0, 5.0, 5.0));
//        Triangle.printTrianglePerimeter(new Triangle(3.0,5.0,5.0));
     }

}

