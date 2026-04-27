package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double toInchesFactor;

        LengthUnit(double factor) {
            this.toInchesFactor = factor;
        }

        public double toBase(double value) {
            return value * toInchesFactor;
        }

        public double fromBase(double baseValue) {
            return baseValue / toInchesFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    private double toBaseInches() {
        return unit.toBase(value);
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    // ---------- UC5 ----------
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = toBaseInches();
        double converted = targetUnit.fromBase(base);

        return new Length(round(converted), targetUnit);
    }

    // ---------- UC6 ----------
    public Length add(Length that) {
        return addAndConvert(that, this.unit);
    }

    // ---------- UC7 ----------
    public Length add(Length that, LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        return addAndConvert(that, targetUnit);
    }

    // 🔥 Core reusable logic
    private Length addAndConvert(Length that, LengthUnit targetUnit) {
        if (that == null) {
            throw new IllegalArgumentException("Cannot add null Length");
        }

        double base1 = this.toBaseInches();
        double base2 = that.toBaseInches();

        double sumBase = base1 + base2;

        double result = targetUnit.fromBase(sumBase);

        return new Length(round(result), targetUnit);
    }

    // ---------- Equality ----------
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        double thisBase = round(this.toBaseInches());
        double otherBase = round(other.toBaseInches());

        return Double.compare(thisBase, otherBase) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round(toBaseInches()));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
