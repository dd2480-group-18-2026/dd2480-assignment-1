import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic14Tests {
    private static ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			5, 
			1, 
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			1, 
			1, 
			0, 
			0, 
			0, 
			0
		);

    /**
     * This test asserts that calculateLIC14 returns true when
     * there exists at least one triplet with area > AREA1
     * AND at least one (possibly different) triplet with area < AREA2.
     */
    @Test
    void calculateLIC14_returnsTrue_whenBothAreaConditionsAreMet() {
        Point[] points = {
            // First valid triangle: large area = 6
            new Point(0, 0),    // A
            new Point(0, 0),    
            new Point(4, 0),    // B
            new Point(0, 0),    
            new Point(0, 3),    // C

            // Second valid triangle: small area = 0.05
            new Point(1, 1),    // A
            new Point(0, 0),
            new Point(2, 1),    // B
            new Point(0, 0),
            new Point(1, 1.1)   // C
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 14);

        assertTrue(result);
    }

    /**
     * This test asserts that calculateLIC14 returns false when
     * no triangle with area > AREA1 exists.
     */
    @Test
    void calculateLIC14_returnsFalse_whenNoAreaGreaterThanArea1() {
        Point[] points = {
            // Not actually a triangle, three points collinear
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(2, 0),

            // A triangle with area = 1/2
            new Point(0, 1),
            new Point(0, 0),
            new Point(1, 1),
            new Point(0, 0),
            new Point(1, 0) 
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 14);

        assertFalse(result);
    }

    /**
     * This test asserts that calculateLIC14 returns false when
     * no triangle with area < AREA2 exists.
     */
    @Test
    void calculateLIC14_returnsFalse_whenNoAreaLessThanArea2() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(5, 0),
            new Point(0, 0),
            new Point(0, 5),   // area = 12.5
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 14);

        assertFalse(result);
    }

    /**
     * This test asserts that calculateLIC14 returns false
     * when NUMPOINTS < 5, regardless of parameter values.
     */
    @Test
    void calculateLIC14_returnsFalse_whenNumPointsLessThanFive() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 1),
            new Point(1, 1)
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 14);

        assertFalse(result);
    }
}
