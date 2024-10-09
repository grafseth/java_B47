package ru.gs.geometry.figures;

public record Square(double side) {

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

    public static void printSquarePerimeter(Square p) {
        String text = String.format("Square perimeter with side %f = %f", p.side, p.area());
        System.out.println(text);
    }


    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
    @Override
    public String toString() {
        return "Square with side: " + side;
    }
}