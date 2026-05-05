package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {
        return q1.equals(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> quantity, U targetUnit) {
        double converted = quantity.convertTo(targetUnit);
        return new Quantity<>(converted, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {
        return q1.add(q2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }

    public static void main(String[] args) {

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2,
                                                   WeightUnit targetUnit) {
        return w1.add(w2, targetUnit);
    }
    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2) {
        return q1.subtract(q2);
    }

    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.subtract(q2, targetUnit);
    }

    public static <U extends IMeasurable> double
    demonstrateDivision(Quantity<U> q1, Quantity<U> q2) {
        return q1.divide(q2);
    }

        System.out.println("Length equal: " +
                demonstrateEquality(length1, length2));

        Quantity<WeightUnit> weight1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000, WeightUnit.GRAM);

        System.out.println("Weight equal: " +
                demonstrateEquality(weight1, weight2));

        System.out.println("10 feet in inches: " +
                length1.convertTo(LengthUnit.INCHES));

        System.out.println("Total length: " +
                demonstrateAddition(length1, length2));

        Quantity<WeightUnit> pounds =
                new Quantity<>(2.2, WeightUnit.POUND);

        System.out.println("Total weight in kg: " +
                demonstrateAddition(weight1, pounds, WeightUnit.KILOGRAM));
    }
}