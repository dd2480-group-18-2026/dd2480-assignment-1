import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic11Tests {
	
	/**
	 * This test asserts that the calculateLIC11 function correctly returns false
	 * when the numPoints parameter is less than 3 (an invalid value).
	 * The valid range for numPoints is 3 <= numPoints.
	 */
	@Test
	void calculateLIC11_returnsFalse_whenNumPointsIsLessThan3() {
		ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			1, //Only one "consecutive" point
			0, 
			0, 
			0 
		);

		Point[] points = {
            new Point(2,0),
            new Point(0,0),
        };

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 11);

		assertFalse(result);
	}

	/**
	 * This test asserts that the calculateLIC11 function behaves correctly 
	 * when given a valid set of parameters and points that do verify the
	 * LIC 11 condition.
	 */
    @Test
	void calculateLIC11_returnsTrue_whenLIC11ConditionIsMet() {
		ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			1, //Only one "consecutive" point
			0, 
			0, 
			0 
		);

		Point[] points = {
            new Point(2,0),
            new Point(0,0),
            new Point(1,0)
        };

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 11);

		assertTrue(result);
	}
    
	/**
	 * This test asserts that the calculateLIC11 function behaves correctly 
	 * when given a valid set of parameters and points that do not verify 
	 * the LIC 11 condition.
	 */
    @Test
	void calculateLIC11_returnsFalse_whenLIC11ConditionIsNotMet() {
		ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			1, //Only one "consecutive" point
			0, 
			0, 
			0 
		);

		Point[] points = {
            new Point(2,0),
            new Point(0,0),
            new Point(3,0)
        };

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 11);

		assertFalse(result);
	}

}
