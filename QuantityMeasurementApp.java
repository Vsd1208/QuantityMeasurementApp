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

        return new Length(value, from).convertTo(to);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit to) {

        return length.convertTo(to);
    }

    // UC6
    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    // ✅ UC7
    public static Length demonstrateLengthAddition(
            Length l1,
            Length l2,
            Length.LengthUnit targetUnit) {

        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println(demonstrateLengthAddition(l1, l2)); // 2 FEET
        System.out.println(demonstrateLengthAddition(l1, l2, Length.LengthUnit.INCHES)); // 24 INCHES
    }
}
