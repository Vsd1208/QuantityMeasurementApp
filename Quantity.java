package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null || Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value or unit");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public double convertTo(U targetUnit) {
        if (targetUnit == null || unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Incompatible units");
        }

        double baseValue = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null || unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible quantities");
        }

        double baseSum = unit.convertToBaseUnit(value)
                + other.unit.convertToBaseUnit(other.value);

        double result = targetUnit.convertFromBaseUnit(baseSum);
        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Null argument");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible units");
        }

        double baseThis = unit.convertToBaseUnit(this.value);
        double baseOther = other.unit.convertToBaseUnit(other.value);

        double baseResult = baseThis - baseOther;

        double result = targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(result, targetUnit);
    }

    public double divide(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Null argument");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible units");
        }

        double baseThis = unit.convertToBaseUnit(this.value);
        double baseOther = other.unit.convertToBaseUnit(other.value);

        if (baseOther == 0.0) {
            throw new ArithmeticException("Division by zero");
        }

        return baseThis / baseOther;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        if (unit.getClass() != other.unit.getClass()) return false;

        double thisBase = unit.convertToBaseUnit(value);
        double thatBase = other.unit.convertToBaseUnit(other.value);

        return Double.compare(thisBase, thatBase) == 0;
    }

    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        return Objects.hash(baseValue, unit.getClass());
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}