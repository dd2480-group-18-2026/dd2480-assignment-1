import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic11Tests {
	
	/**
	 * This test asserts that the calculateLIC11 function correctly returns false
	 * when the numPoints parameter is less than 3 (invalid value).
	 * The valid range for numPoints is 3 <= numPoints.
	 */
	@Test
	void calculateLIC11_returnsFalse_whenNumPointsIsLessThan3() {
		ParameterStruct parameters = new ParameterStruct();
		//Only one "consecutive" intervening point
		parameters.G_PTS = 1;

		Point[] points = {
            new Point(2,0),
            new Point(0,0),
        };

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 11);

		assertFalse(result);
	}

	/**
	 * This test asserts that the calculateLIC11 function behaves correctly 
	 * when given a valid set of parameters and points that do meet the
	 * LIC 11 condition. The condition is met if there exists at least one
	 * set of two data points, (X[i],Y[i]) and (X[j],Y[j]), separated by exactly
	 * G_PTS consecutive intervening points, such that X[j] - X[i] < 0. 
	 * (where i < j ) The condition is not met when NUMPOINTS < 3.
	 * 1 ≤ G_PTS ≤ NUMPOINTS − 2
	 */
    @Test
	void calculateLIC11_returnsTrue_whenLIC11ConditionIsMet() {
		ParameterStruct parameters = new ParameterStruct();
		//Only one "consecutive" intervening point
		parameters.G_PTS = 1;

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
	 * when given a valid set of parameters and points that do not meet 
	 * the LIC 11 condition. The condition is met if there exists at least one
	 * set of two data points, (X[i],Y[i]) and (X[j],Y[j]), separated by exactly
	 * G_PTS consecutive intervening points, such that X[j] - X[i] < 0. 
	 * (where i < j ) The condition is not met when NUMPOINTS < 3.
	 * 1 ≤ G_PTS ≤ NUMPOINTS − 2
	 */
    @Test
	void calculateLIC11_returnsFalse_whenLIC11ConditionIsNotMet() {
		ParameterStruct parameters = new ParameterStruct();
		//Only one "consecutive" intervening point
		parameters.G_PTS = 1;

		Point[] points = {
            new Point(2,0),
            new Point(0,0),
            new Point(3,0)
        };

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 11);

		assertFalse(result);
	}

}
