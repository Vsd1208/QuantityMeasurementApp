package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    // ---------- UC7 TESTS ----------

    @Test
    public void testAdd_FeetAndInches_TargetFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.FEET);

        assertTrue(result.equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAdd_FeetAndInches_TargetInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.INCHES);

        assertTrue(result.equals(new Length(24.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testAdd_YardAndFeet_TargetYards() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = l1.add(l2, Length.LengthUnit.YARDS);

        assertTrue(result.equals(new Length(2.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testAdd_CentimeterAndInch_TargetCm() {
        Length l1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), 0.01);
    }

    @Test
    public void testAdd_Commutative() {
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);

        double r1 = a.add(b, Length.LengthUnit.INCHES).getValue();
        double r2 = b.add(a, Length.LengthUnit.INCHES).getValue();

        assertEquals(r1, r2, EPS);
    }

    @Test
    public void testAdd_WithZero() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.FEET);

        assertTrue(result.equals(new Length(5.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAdd_Null() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(null, Length.LengthUnit.FEET);
        });
    }
}
