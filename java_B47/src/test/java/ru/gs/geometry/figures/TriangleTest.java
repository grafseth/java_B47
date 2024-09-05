package ru.gs.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void canCalculateArea() {
        var t = new Triangle(3.0, 5.0, 7.0);
        double result = t.area();
        Assertions.assertEquals(6.5, result);
    }
@Test
    void canCalculatePerimeter() {
        var t = new Triangle(3.0,5.0,5.0);
        Assertions.assertEquals(13.0, new Triangle (3.0,5.0,5.0).perimeter());
    }

}
