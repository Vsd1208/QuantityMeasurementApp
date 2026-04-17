public class QuantityMeasurementApp {

    // ================= ENUM =================
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

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

        // Core comparison logic
        public boolean compare(Length that) {
            return Double.compare(this.convertToBaseUnit(),
                    that.convertToBaseUnit()) == 0;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Length length = (Length) o;
            return compare(length);
        }
    }

    // ================= DEMO METHODS =================

    public static boolean demonstrateLengthComparison(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateFeetEquality() {
        System.out.println(
                demonstrateLengthComparison(
                        new Length(1.0, LengthUnit.FEET),
                        new Length(1.0, LengthUnit.FEET)
                )
        );
    }

    public static void demonstrateInchesEquality() {
        System.out.println(
                demonstrateLengthComparison(
                        new Length(1.0, LengthUnit.INCHES),
                        new Length(1.0, LengthUnit.INCHES)
                )
        );
    }

    public static void demonstrateYardInchesComparison() {
        System.out.println(
                demonstrateLengthComparison(
                        new Length(1.0, LengthUnit.YARDS),
                        new Length(36.0, LengthUnit.INCHES)
                )
        );
    }

    public static void demonstrateFeetYardComparison() {
        System.out.println(
                demonstrateLengthComparison(
                        new Length(3.0, LengthUnit.FEET),
                        new Length(1.0, LengthUnit.YARDS)
                )
        );
    }

    public static void demonstrateCmFeetComparison() {
        System.out.println(
                demonstrateLengthComparison(
                        new Length(38.48, LengthUnit.CENTIMETERS),
                        new Length(1.0, LengthUnit.FEET)
                )
        );
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateYardInchesComparison();
        demonstrateFeetYardComparison();
        demonstrateCmFeetComparison();
    }
}