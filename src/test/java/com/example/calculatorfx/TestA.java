package com.example.calculatorfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.InputMismatchException;

public class TestA {
    @Test
    public void testTrapezoid() throws NotNaturalNumberException, ImpossibleTriangleException {
        Assertions.assertEquals(21.83, Math.round(new Trapezoid(6, 5, 4, 4).area() * 100.0) / 100.0);
        Assertions.assertThrows(ImpossibleTriangleException.class, () -> new Trapezoid(6, 5, 4, 3).area());
        Assertions.assertThrows(NotNaturalNumberException.class, () -> new Trapezoid(6, 5, 4, -3).area());
    }
}
