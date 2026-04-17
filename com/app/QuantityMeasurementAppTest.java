import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesEquality() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.INCHES);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetToInchesEquality() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(12.0, QuantityMeasurementApp.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testDifferentValues() {
        QuantityMeasurementApp.Length l1 =
                new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.Length l2 =
                new QuantityMeasurementApp.Length(2.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }
}