package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        return new Length(value, from).convertTo(to);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2, LengthUnit targetUnit) {
        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length feet = new Length(3, LengthUnit.FEET);
        Length yard = new Length(1, LengthUnit.YARDS);

        System.out.println("3 feet equals 1 yard? " + feet.equals(yard));

        Length converted = demonstrateLengthConversion(1, LengthUnit.FEET, LengthUnit.INCHES);
        System.out.println("1 foot in inches: " + converted);

        Length sum = demonstrateLengthAddition(feet, yard, LengthUnit.FEET);
        System.out.println("Sum in feet: " + sum);
    }
}
