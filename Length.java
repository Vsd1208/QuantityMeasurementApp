package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert to another unit
    public Length convertTo(LengthUnit targetUnit) {
        double baseValue = convertToBaseUnit();
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Length(convertedValue, targetUnit);
    }

    // Add two lengths (result in same unit as this)
    public Length add(Length other) {
        double sum = this.convertToBaseUnit() + other.convertToBaseUnit();
        double result = unit.convertFromBaseUnit(sum);
        return new Length(result, unit);
    }

    // Add with target unit
    public Length add(Length other, LengthUnit targetUnit) {
        double sum = this.convertToBaseUnit() + other.convertToBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sum);
        return new Length(result, targetUnit);
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length that = (Length) o;
        return Double.compare(this.convertToBaseUnit(), that.convertToBaseUnit()) == 0;
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
