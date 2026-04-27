package com.apps.quantitymeasurement;

public enum WeightUnit {

    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // Convert to base unit (grams)
    public double convertToBaseUnit(double value) {
        return round(value * conversionFactor);
    }

    // Convert from base unit (grams)
    public double convertFromBaseUnit(double baseValue) {
        return round(baseValue / conversionFactor);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
