package com.apps.quantitymeasurement;

import java.util.Objects;

public class Weight {

    private double value;
    private WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    // Convert weight to another unit
    public Weight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = convertToBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Weight(converted, targetUnit);
    }

    // Add weights (same unit as this)
    public Weight add(Weight other) {
        return addAndConvert(other, this.unit);
    }

    // Add weights with target unit
    public Weight add(Weight other, WeightUnit targetUnit) {
        return addAndConvert(other, targetUnit);
    }

    private Weight addAndConvert(Weight other, WeightUnit targetUnit) {
        double sum = this.convertToBaseUnit() + other.convertToBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sum);
        return new Weight(result, targetUnit);
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private boolean compare(Weight other) {
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;
        Weight that = (Weight) o;
        return compare(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
