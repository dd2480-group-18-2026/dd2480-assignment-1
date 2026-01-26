import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic4Tests {
	/**
	 * This test asserts that the calculateLIC4 function behaves correctly 
	 * when given a valid set of parameters and points that do verify the
	 * LIC 4 condition.
	 */
    @Test
	void calculateLIC4_returnsTrue_whenConsecutivePointsInEnoughQuads() {
		ParameterStruct parameters = new ParameterStruct();
		parameters.QUADS = 2;
		parameters.Q_PTS = 4;

		Point[] points = {
			new Point(0, 0),    
			new Point(1, 0),    
			new Point(0, 1), // Q1

			// 4 consecutive points in exactly 3 quadrants 
			new Point(2, 3), // Q1
			new Point(1, 7),  // Q1
			new Point(-4, 1), // Q2
			new Point(3, -5), // Q4

			new Point(0, -1),   
			new Point(-2, 0),   
			new Point(0, 0)
		};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 4);

		assertTrue(result);
	}

	/**
	 * This test asserts that the calculateLIC4 function behaves correctly 
	 * when given a valid set of parameters and points that do not verify 
	 * the LIC 4 condition.
	 */
	@Test
	void calculateLIC4_returnsFalse_whenNotEnoughConsecutivePointsInQuads() {
		ParameterStruct parameters = new ParameterStruct();
		parameters.QUADS = 2;
		parameters.Q_PTS = 8;

		Point[] points = {
			new Point(0, 0), // Q1
			new Point(1, 0), // Q1
			new Point(0, 1), // Q1

			new Point(2, 3), // Q1
			new Point(1, 7),  // Q1
			new Point(-4, 1), // Q2
			new Point(3, 5), // Q1

			new Point(-1, 0), // Q2
			new Point(-2, 2), // Q2
			new Point(0, 0) // Q1
		};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 4);

		assertFalse(result);
	}

	/**
	 * This test asserts that the calculateLIC4 function correctly returns false
	 * when the QUADS parameter holds an invalid value and doesn't panic.
	 * The valid range is 1 <= QUADS <= 3.
	 */
    @Test
	void calculateLIC4_invalidQUADS() {
		ParameterStruct parameters = new ParameterStruct();
		parameters.QUADS = 5;
		parameters.Q_PTS = 8;

		Point[] points = {
			new Point(0, 0), // Q1
			new Point(1, 0), // Q1
			new Point(0, 1), // Q1

			// 4 consecutive points in exactly 3 quadrants 
			new Point(2, 3), // Q1
			new Point(1, 7),  // Q1
			new Point(-4, 1), // Q2
			new Point(3, 5), // Q1

			new Point(-1, 0), // Q2
			new Point(-2, 2), // Q2
			new Point(0, 0) // Q1
		};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 4);

		assertFalse(result);
	}

	/**
	 * This test asserts that the calculateLIC4 function correctly returns false
	 * when the Q_PTS parameter holds an invalid value and doesn't panic.
	 * The valid range for Q_PTS is 1 <= Q_PTS <= numPoints.
	 */
    @Test
	void calculateLIC4_invalidQPTS() {
		ParameterStruct parameters = new ParameterStruct();
		parameters.QUADS = 1;
		parameters.Q_PTS = 20;

		Point[] points = {
			new Point(0, 0), // Q1
			new Point(1, 0), // Q1
			new Point(0, 1), // Q1

			new Point(2, 3), // Q1
			new Point(1, 7),  // Q1
			new Point(-4, 1), // Q2
			new Point(3, 5), // Q1

			new Point(-1, 0), // Q2
			new Point(-2, 2), // Q2
			new Point(0, 0) // Q1
		};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 4);

		assertFalse(result);
	}
}
