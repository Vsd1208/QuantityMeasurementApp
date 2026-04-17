public class QuantityMeasurementApp {

    // ================= ENUM =================
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // ================= GENERIC CLASS =================
    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        // Convert everything to INCHES (base unit)
        private double convertToBaseUnit() {
            return this.value * unit.getConversionFactor();
        }

        public boolean compare(Length that) {
            return Double.compare(this.convertToBaseUnit(),
                    that.convertToBaseUnit()) == 0;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Length length = (Length) o;
            return this.compare(length);
        }
    }

    // ================= DEMO METHODS =================

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateFeetEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        System.out.println("Feet Equal? " + l1.equals(l2));
    }

    public static void demonstrateInchesEquality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Inches Equal? " + l1.equals(l2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Feet vs Inches Equal? " + l1.equals(l2));
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}