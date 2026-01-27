import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic6Tests {
    
    /** 
     * Asserts that calculateLIC6 returns true when given three points and
     * the middle point is further than DIST from the line that goes
     * between the first two points. This does satisfy the LIC6 condition.
     */
    @Test 
    void calculateLIC6_returnsTrue_whenMiddlePointFurtherThanDistFromLineBetweenFirstAndLastPoint() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.N_PTS = 3;
        parameters.DIST = 1;

        Point[] points = {
            new Point(-1,0),
            new Point(0,2),
            new Point(1,0)
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 6);

		assertTrue(result);
    }

    /** 
     * Asserts that calculateLIC6 returns false when given three points and
     * the middle point is closer than DIST from the line that goes
     * between the first two points. This does not satisfy the LIC6 condition.
     */
    @Test 
    void calculateLIC6_returnsFalse_whenMiddlePointCloserThanDistFromLineBetweenFirstAndLastPoint() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.N_PTS = 3;
        parameters.DIST = 3;

        Point[] points = {
            new Point(-1,0),
            new Point(0,2),
            new Point(1,0)
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 6);

		assertFalse(result);
    }

    /**
     * Asserts that calculateLIC6 returns true when given three points, with
     * the first and last points being identical, and middle point is further
     * than DIST from the line that goes between the first two points. This
     * does satisfy the LIC6 condition.
     */
    @Test
    void calculateLIC6_returnsTrue_whenFirstAndLastPointsAreTheSameAndMiddlePointIsFurtherThanDistFromThatPoint() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.N_PTS = 3;
        parameters.DIST = 0;
        
        Point[] points = {
            new Point(0,0),
            new Point(0,1),
            new Point(0,0)
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 6);

		assertTrue(result);
    }

    /**
     * Asserts that calculateLIC6 returns true when given three points, with
     * the first and last points being identical, and middle point is closer
     * than DIST from the line that goes between the first two points. This
     * does not satisfy the LIC6 condition.
     * 
     */
    @Test
    void calculateLIC6_returnsFalse_whenFirstAndLastPointsAreTheSameAndMiddlePointIsCloserThanDistFromThatPoint() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.N_PTS = 3;
        parameters.DIST = 2;
        
        Point[] points = {
            new Point(0,0),
            new Point(0,1),
            new Point(0,0)
        };

        boolean result = LicHelper.calculateLIC(parameters, points.length, points, 6);

		assertFalse(result);
    }


}
