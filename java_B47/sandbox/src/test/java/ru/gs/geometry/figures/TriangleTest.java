package ru.gs.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void canCalculateArea() {
        var t = new Triangle(3.0, 5.0, 7.0);
        double result = t.area();
        Assertions.assertEquals(6.49519052838329, result);
    }

    @Test
    void canCalculatePerimeter() {
        var t = new Triangle(3.0, 5.0, 5.0);
        Assertions.assertEquals(13.0, new Triangle(3.0, 5.0, 5.0).perimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, -3.0, -3.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }

    @Test
    void cannotCreateTriangleWithIncorrectSide() {
        try {
        new Triangle(3.0, 3.0, 7.0);
        Assertions.fail();
    } catch (IllegalArgumentException exception) {
        }
    }
    @Test
    void testEquality() {
        var t1 = new Triangle(3.0,4.0,5.0);
        var t2 = new Triangle(4.0,5.0,3.0);
        Assertions.assertEquals(t1, t2);
    }
}
