package ru.gs.geometry.figures;

public class Square {

    private double side;

    public Square(double side) {
        this.side = side;
if (side < 0) {
    throw new IllegalArgumentException("Square side should be non negative");
}

    }

    public static void printSquareArea(Square s) {
        String text = String.format("Square area with side %f = %f", s.side, s.area());
        System.out.println(text);
    }

    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}