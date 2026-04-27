package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Equality
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        if (l1 == null || l2 == null) return false;
        return l1.equals(l2);
    }

    // Conversion (raw input)
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit from,
            Length.LengthUnit to) {

        return new Length(value, from).convertTo(to);
    }

    // Conversion (object input)
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit to) {

        if (length == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }
        return length.convertTo(to);
    }

    // UC5 static convert API
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

    // ✅ UC6 Addition API
    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Lengths cannot be null");
        }
        return l1.add(l2);
    }

    public static void main(String[] args) {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = demonstrateLengthAddition(l1, l2);

        System.out.println(result); // 2.0 FEET
    }
}