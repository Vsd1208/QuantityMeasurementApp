package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testFeetToInches() {
        double result = QuantityMeasurementApp.convert(
                1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES
        );
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void testInchesToFeet() {
        double result = QuantityMeasurementApp.convert(
                24.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET
        );
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testYardsToInches() {
        double result = QuantityMeasurementApp.convert(
                1.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES
        );
        assertEquals(36.0, result, EPSILON);
    }

    @Test
    public void testCentimeterToInches() {
        double result = QuantityMeasurementApp.convert(
                2.54,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES
        );
        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testZeroConversion() {
        double result = QuantityMeasurementApp.convert(
                0.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES
        );
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    public void testNegativeConversion() {
        double result = QuantityMeasurementApp.convert(
                -1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES
        );
        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    public void testSameUnit() {
        double result = QuantityMeasurementApp.convert(
                5.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.FEET
        );
        assertEquals(5.0, result, EPSILON);
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(
                        Double.NaN,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES
                )
        );
    }

    @Test
    public void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(
                        1.0,
                        null,
                        Length.LengthUnit.INCHES
                )
        );
    }

    @Test
    public void testRoundTrip() {
        double original = 5.0;

        double converted = QuantityMeasurementApp.convert(
                original,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES
        );

        double back = QuantityMeasurementApp.convert(
                converted,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET
        );

        assertEquals(original, back, EPSILON);
    }
}