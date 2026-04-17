import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ================= FEET =================
    @Test
    public void testFeetToFeet_SameValue() {
        assertTrue(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET)
                .equals(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    // ================= YARD =================
    @Test
    public void testYardToYard_SameValue() {
        assertTrue(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.YARDS)
                .equals(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.YARDS)));
    }

    @Test
    public void testYardToFeet_Equivalent() {
        assertTrue(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.YARDS)
                .equals(new QuantityMeasurementApp.Length(3.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    public void testFeetToYard_Equivalent() {
        assertTrue(new QuantityMeasurementApp.Length(3.0, QuantityMeasurementApp.LengthUnit.FEET)
                .equals(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.YARDS)));
    }

    @Test
    public void testYardToInches_Equivalent() {
        assertTrue(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.YARDS)
                .equals(new QuantityMeasurementApp.Length(36.0, QuantityMeasurementApp.LengthUnit.INCHES)));
    }

    // ================= CENTIMETERS =================
    @Test
    public void testCmToInches_Equivalent() {
        assertTrue(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETERS)
                .equals(new QuantityMeasurementApp.Length(0.393701, QuantityMeasurementApp.LengthUnit.INCHES)));
    }

    @Test
    public void testCmToFeet_NotEqual() {
        assertFalse(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETERS)
                .equals(new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET)));
    }

    // ================= EDGE CASES =================
    @Test
    public void testSameReference() {
        QuantityMeasurementApp.Length l =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(l.equals(l));
    }

    @Test
    public void testNullComparison() {
        QuantityMeasurementApp.Length l =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(l.equals(null));
    }
}