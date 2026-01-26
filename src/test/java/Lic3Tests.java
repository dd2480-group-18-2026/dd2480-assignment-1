import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic3Tests {

    private static ParameterStruct params(double area1) {
        return new ParameterStruct(
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            area1,
            0.0,
            1,
            0.0,
            1, 1, 1, 1, 1, 1, 1, 1, 3, 2
        );
    }

    @Test
    void calculateLIC3_returnsTrue_whenTriangleAreaGreaterThanAREA1() {
        Point[] points = { new Point(0, 0), new Point(4, 0), new Point(0, 3) };
        boolean result = LicHelper.calculateLIC(params(5.0), points.length, points, 3);
        assertTrue(result);
    }

    @Test
    void calculateLIC3_returnsFalse_whenTriangleAreaEqualToAREA1() {
        Point[] points = { new Point(0, 0), new Point(4, 0), new Point(0, 3) };
        boolean result = LicHelper.calculateLIC(params(6.0), points.length, points, 3);
        assertFalse(result);
    }

    @Test
    void calculateLIC3_returnsFalse_whenLessThanThreePoints() {
        Point[] points = { new Point(0, 0), new Point(1, 1) };
        boolean result = LicHelper.calculateLIC(params(0.0), points.length, points, 3);
        assertFalse(result);
    }
}
