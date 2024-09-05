package ru.gs.geometry.figures;

public class Triangle {

    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public static void printTriangleArea(Triangle triangle) {
        String text = String.format("Triangle area withs sides %f, %f and %f = %f", triangle.side1, triangle.side2, triangle.side3, triangle.area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle triangle) {
        String text = String.format("Triangle perimeter withs sides %f, %f and %f = %f", triangle.side1, triangle.side2, triangle.side3, triangle.perimeter());
        System.out.println(text);
    }

    public double area() {
        double s = semiPerimeter();
        return Math.sqrt(s *(s -side1)*(s -side2)*(s -side3));
    }

    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double semiPerimeter() {
        return perimeter()/2;
    }

}
