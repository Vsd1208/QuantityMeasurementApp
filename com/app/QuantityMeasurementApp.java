public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {

        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        /**
         * Override equals() to compare two Feet objects
         */
        @Override
        public boolean equals(Object obj) {

            // 1. Same reference check
            if (this == obj) return true;

            // 2. Null or type check
            if (obj == null || getClass() != obj.getClass()) return false;

            // 3. Cast safely
            Feet feet = (Feet) obj;

            // 4. Compare values using Double.compare
            return Double.compare(feet.value, this.value) == 0;
        }

        // (Optional but recommended when overriding equals)
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method to test manually
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Are equal? " + f1.equals(f2)); // true
    }
}