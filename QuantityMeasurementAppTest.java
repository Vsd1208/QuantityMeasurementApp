package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ===== WEIGHT TESTS =====

    @Test
    public void kilogramEquals1000Grams() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void poundEquals453Point592Grams() {
        Weight w1 = new Weight(1, WeightUnit.POUND);
        Weight w2 = new Weight(453.592, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void tonneEquals1000000Grams() {
        Weight w1 = new Weight(1, WeightUnit.TONNE);
        Weight w2 = new Weight(1_000_000, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void kilogramNotEqualToPound() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1, WeightUnit.POUND);
        assertNotEquals(w1, w2);
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        Weight w1 = new Weight(500, WeightUnit.GRAM);
        Weight w2 = new Weight(500, WeightUnit.GRAM);
        Weight result = w1.add(w2);

        assertEquals(new Weight(1000, WeightUnit.GRAM), result);
    }

    @Test
    public void additionWithTargetUnit() {
        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(500, WeightUnit.GRAM);

        Weight result = w1.add(w2, WeightUnit.KILOGRAM);

        assertEquals(new Weight(1.5, WeightUnit.KILOGRAM), result);
    }

    @Test
    public void convertKilogramToGram() {
        Weight result = new Weight(1, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM);

        assertEquals(new Weight(1000, WeightUnit.GRAM), result);
    }

    // ===== LENGTH TESTS =====

    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    public void testInchesEquality() {
        Length l1 = new Length(36, LengthUnit.INCHES);
        Length l2 = new Length(1, LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(
            QuantityMeasurementApp.demonstrateLengthComparison(
                1, LengthUnit.FEET,
                12, LengthUnit.INCHES
            )
        );
    }

    @Test
    public void testFeetInequality() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(13, LengthUnit.INCHES);
        assertNotEquals(l1, l2);
    }

    @Test
    public void testCrossUnitInequality() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(1, LengthUnit.YARDS);
        assertNotEquals(l1, l2);
    }

    @Test
    public void yardEquals36Inches() {
        Length l1 = new Length(1, LengthUnit.YARDS);
        Length l2 = new Length(36, LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    public void centimeterEqualsInches() {
        Length l1 = new Length(2.54, LengthUnit.CENTIMETERS);
        Length l2 = new Length(1, LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length l1 = new Length(3, LengthUnit.FEET);
        Length l2 = new Length(1, LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    public void convertFeetToInches() {
        Length result = new Length(1, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);

        assertEquals(new Length(12, LengthUnit.INCHES), result);
    }

    @Test
    public void addFeetAndInches() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(6, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(1.5, LengthUnit.FEET), result);
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(6, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.INCHES);

        assertEquals(new Length(18, LengthUnit.INCHES), result);
    }

    // ===== EDGE CASES =====

    @Test
    public void referenceEqualitySameObject() {
        Length l1 = new Length(1, LengthUnit.FEET);
        assertEquals(l1, l1);
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l1 = new Length(1, LengthUnit.FEET);
        assertNotEquals(null, l1);
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(2, LengthUnit.FEET);
        assertNotEquals(l1, l2);
    }
}
