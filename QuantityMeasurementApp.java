package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        if (l1 == null || l2 == null) return false;
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit from,
            Length.LengthUnit to) {

        Length length = new Length(value, from);
        return length.convertTo(to);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit to) {

        if (length == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }
        return length.convertTo(to);
    }

    // Static API (UC5 requirement)
    public static double convert(double value,
                                 Length.LengthUnit source,
                                 Length.LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double base = source.toBase(value);
        return target.fromBase(base);
    }

    public static void main(String[] args) {
        System.out.println(convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES)); // 12
    }
}