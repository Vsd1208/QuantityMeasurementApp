import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ===== FEET TESTS =====

    @Test
    public void testFeetEquality_SameValue() {
        assertTrue(new QuantityMeasurementApp.Feet(1.0)
                .equals(new QuantityMeasurementApp.Feet(1.0)));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        assertFalse(new QuantityMeasurementApp.Feet(1.0)
                .equals(new QuantityMeasurementApp.Feet(2.0)));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        assertFalse(new QuantityMeasurementApp.Feet(1.0).equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        assertFalse(new QuantityMeasurementApp.Feet(1.0)
                .equals("1.0"));
    }

    @Test
    public void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet f = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(f.equals(f));
    }

    // ===== INCHES TESTS =====

    @Test
    public void testInchesEquality_SameValue() {
        assertTrue(new QuantityMeasurementApp.Inches(1.0)
                .equals(new QuantityMeasurementApp.Inches(1.0)));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        assertFalse(new QuantityMeasurementApp.Inches(1.0)
                .equals(new QuantityMeasurementApp.Inches(2.0)));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        assertFalse(new QuantityMeasurementApp.Inches(1.0).equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        assertFalse(new QuantityMeasurementApp.Inches(1.0)
                .equals("1.0"));
    }

    @Test
    public void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches i = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(i.equals(i));
    }
}