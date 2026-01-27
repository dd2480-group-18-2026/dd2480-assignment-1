import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic1Tests {

    /**
     * Asserts that calculateLIC1 returns true when given three points that
     * cannot all be contained within the given radius. This does satisfy the LIC1 condition.
     */
    @Test 
    void calculateLIC1_returnsTrue_whenThreeConsecutivePointsAreNotWithinRadius()
    {
        ParameterStruct parameters = new ParameterStruct();
        parameters.RADIUS_1 = 1.0;
        
        Point[] points = {
            new Point(0,0),
            new Point(1,0),
            new Point(3,0)
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 1);

        assertTrue(result);
    }
    
    /**
     * Asserts that calculateLIC1 returns false when given three points that
     * can all be contained within the given radius. This does not satisfy the LIC1 condition.
     */
    @Test 
    void calculateLIC1_returnsFalse_whenThreeConsecutivePointsAreWithinRadius()
    {
        ParameterStruct parameters = new ParameterStruct();
        parameters.RADIUS_1 = 1.0;
        
        Point[] points = {
            new Point(0,0),
            new Point(1,0),
            new Point(2,0)
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 1);

        assertFalse(result);
    }
}
