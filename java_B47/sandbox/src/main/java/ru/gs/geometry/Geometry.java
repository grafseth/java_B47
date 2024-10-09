package ru.gs.geometry;

import ru.gs.geometry.figures.Rectangle;
import ru.gs.geometry.figures.Square;
import ru.gs.geometry.figures.Triangle;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSquare).limit(5);
        squares.peek(Square::printSquareArea).forEach(Square::printSquarePerimeter);


//        Rectangle.printRectangleArea(3.0, 5.0);
//        Rectangle.printRectangleArea(7.0, 9.0);
//
//        Triangle.printTriangleArea(new Triangle(3.0, 5.0, 5.0));
//        Triangle.printTrianglePerimeter(new Triangle(3.0,5.0,5.0));
     }

}

