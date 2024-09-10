package ru.gs.geometry.figures;

import java.util.Arrays;

public record Triangle(double side1, double side2, double side3) {

    public Triangle (double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
            if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (side1 + side2 < side3 || side2 + side3 < side1 || side3 + side1 < side2) {
            throw new IllegalArgumentException("Triangle side equality error");
        }
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
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double semiPerimeter() {
        return perimeter() / 2;
    }

    @Override
    public String toString() {
        return "Triangle with sides: " + side1 + ", " + side2 + ", " + side3;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Triangle triangle = (Triangle) obj;

        double[] thisSides = {side1, side2, side3};
        double[] otherSides = {triangle.side1, triangle.side2, triangle.side3};

        Arrays.sort(thisSides);
        Arrays.sort(otherSides);

        return Arrays.equals(thisSides, otherSides);
    }

    @Override
    public int hashCode() {
        double[] sides = {side1, side2, side3};
        Arrays.sort(sides);
        return Arrays.hashCode(sides);
    }
}