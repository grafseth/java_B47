package ru.gs.geometry.figures;

public record Rectangle(
        double a,
        double b
) {

    public Rectangle {
        if (a < 0) {
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
        if (b < 0) {
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    public static void printRectangleArea(double a, double b) {
        var text = String.format("Rectangle area with sides %f and %f = %f", a, b, rectangleArea(a, b));
        System.out.println(text);
    }

    private static Object rectangleArea(double a, double b) {
    return a * b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(this.a, rectangle.a) == 0 && Double.compare(this.b, rectangle.b) == 0)
                || (Double.compare(this.b, rectangle.a) == 0 && Double.compare(this.a, rectangle.b) == 0);
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(a);
        result = 31 * result + Double.hashCode(b);
        return result;
    }
}

