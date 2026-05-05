package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnit> feet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(120, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    public void lengthYardsEqualsFeet() {
        Quantity<LengthUnit> yards = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> feet = new Quantity<>(3, LengthUnit.FEET);

        assertEquals(yards, feet);
    }
    @Test
    public void weightKilogramEqualsGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(kg, grams);
    }

    @Test
    public void weightPoundEqualsGrams() {
        Quantity<WeightUnit> pound = new Quantity<>(1, WeightUnit.POUND);
        Quantity<WeightUnit> grams = new Quantity<>(453.592, WeightUnit.GRAM);

        assertEquals(pound, grams);
    }
    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnit> feet = new Quantity<>(10, LengthUnit.FEET);

        double result = feet.convertTo(LengthUnit.INCHES);

        assertEquals(120.0, result);
    }

    @Test
    public void convertWeightKilogramsToGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(2, WeightUnit.KILOGRAM);

        double result = kg.convertTo(WeightUnit.GRAM);

        assertEquals(2000.0, result);
    }

    @Test
    public void convertLengthYardsToInches() {
        Quantity<LengthUnit> yards = new Quantity<>(1, LengthUnit.YARDS);

        double result = yards.convertTo(LengthUnit.INCHES);

        assertEquals(36.0, result);
    }
    @Test
    public void addLengthFeetAndInches() {
        Quantity<LengthUnit> feet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(120, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.add(inches);

        assertEquals(20.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void addLengthYardsAndFeet() {
        Quantity<LengthUnit> yards = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> feet = new Quantity<>(3, LengthUnit.FEET);

        Quantity<LengthUnit> result = yards.add(feet);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }
    @Test
    public void addWeightKilogramsAndGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(500, WeightUnit.GRAM);

        Quantity<WeightUnit> result = kg.add(grams);

        assertEquals(1.5, result.getValue());
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void addWeightKilogramsAndPounds() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> pounds = new Quantity<>(2.20462, WeightUnit.POUND);

        Quantity<WeightUnit> result = kg.add(pounds, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue());
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void addWeightTonnesAndKilograms() {
        Quantity<WeightUnit> tonne = new Quantity<>(1, WeightUnit.TONNE);
        Quantity<WeightUnit> kg = new Quantity<>(1000, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = tonne.add(kg, WeightUnit.TONNE);

        assertEquals(2.0, result.getValue());
    }
    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }

    @Test
    public void preventCrossTypeAdditionLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KILOGRAM);

        assertThrows(ClassCastException.class, () -> {
            // Forced unsafe cast to simulate misuse
            Quantity unsafe = (Quantity) weight;
            length.add(unsafe);
        });
    }

    @Test
    public void preventCrossTypeConversionLengthToWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            length.convertTo((LengthUnit) (Object) WeightUnit.KILOGRAM);
        });
    }
    @Test
    public void backwardCompatibilityLengthFeetEqualsInches() {
        Quantity<LengthUnit> feet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(120, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void backwardCompatibilityWeightKilogramEqualsGrams() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000, WeightUnit.GRAM);

        assertTrue(kg.equals(grams));
    }

    @Test
    public void backwardCompatibilityAddLengthInSameUnit() {
        Quantity<LengthUnit> a = new Quantity<>(5, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.add(b);

        assertEquals(10.0, result.getValue());
    }

    @Test
    public void backwardCompatibilityAddWeightInSameUnit() {
        Quantity<WeightUnit> a = new Quantity<>(500, WeightUnit.GRAM);
        Quantity<WeightUnit> b = new Quantity<>(500, WeightUnit.GRAM);

        Quantity<WeightUnit> result = a.add(b);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    public void backwardCompatibilityChainedAdditionsLength() {
        Quantity<LengthUnit> a = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12, LengthUnit.INCHES);
        Quantity<LengthUnit> c = new Quantity<>(1, LengthUnit.YARDS);

        Quantity<LengthUnit> result = a.add(b).add(c);

        assertEquals(5.0, result.getValue()); // 1ft + 1ft + 3ft = 5ft
    }
}