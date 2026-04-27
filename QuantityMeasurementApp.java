package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ===== WEIGHT METHODS =====

    public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static boolean demonstrateWeightComparison(double v1, WeightUnit u1,
                                                      double v2, WeightUnit u2) {
        return new Weight(v1, u1).equals(new Weight(v2, u2));
    }

    public static Weight demonstrateWeightConversion(double value,
                                                     WeightUnit from,
                                                     WeightUnit to) {
        return new Weight(value, from).convertTo(to);
    }

    public static Weight demonstrateWeightConversion(Weight weight,
                                                     WeightUnit to) {
        return weight.convertTo(to);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2) {
        return w1.add(w2);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2,
                                                   WeightUnit targetUnit) {
        return w1.add(w2, targetUnit);
    }

    // ===== MAIN =====

    public static void main(String[] args) {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println("Equal? " + demonstrateWeightEquality(w1, w2));

        Weight converted = demonstrateWeightConversion(2, WeightUnit.POUND, WeightUnit.GRAM);
        System.out.println("2 pounds in grams: " + converted);

        Weight sum = demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        System.out.println("Sum in kg: " + sum);
    }
}
