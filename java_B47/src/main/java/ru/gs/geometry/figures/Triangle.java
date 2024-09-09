package ru.gs.geometry.figures;

public final class Triangle {

    private static double side1;
    private static double side2;
    private static double side3;

    public Triangle(double side1, double side2, double side3) {
        if (side1 < 0 || side2 < 0 || side3 <0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
if (side1 + side2 < side3 || side2 + side3 < side1 || side3 + side1 < side2) {
    throw new IllegalArgumentException("Triangle side equality error");
}
        Triangle.side1 = side1;
        Triangle.side2 = side2;
        Triangle.side3 = side3;
    }

    public static void printTriangleArea(Triangle triangle) {
        String text = String.format("Triangle area withs sides %f, %f and %f = %f", side1, side2, side3, triangle.area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle triangle) {
        String text = String.format("Triangle perimeter withs sides %f, %f and %f = %f", side1, side2, side3, triangle.perimeter());
        System.out.println(text);
    }

    public double area() {
        double s = semiPerimeter();
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double semiPerimeter() {
        return perimeter() / 2;
    }
}