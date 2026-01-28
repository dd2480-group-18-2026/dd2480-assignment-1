import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Lic7Tests {
	private final static ParameterStruct parameters = new ParameterStruct();
	@BeforeAll
	static void init() {
		parameters.LENGTH_1 = 0;
		parameters.K_PTS = 3;
	}

	/**
	 * Test that calculateLIC7 returns true if 2 points separated by K_PTS are at a distance greater than LENGTH_1
	 */
	@Test
	void calculateLIC7_returnsTrue_whenPointsAtDistanceGreaterThanLength1() {
		Point[] points = {
			new Point(3, 3),
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
			new Point(105, 105) // Distance is ~144.25
		};
		parameters.LENGTH_1 = 100;

		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 7));
	}

	/**
	 * Test that calculateLIC7 returns false if 2 points separated by K_PTS are at a distance less than LENGTH_1
	 */
	@Test
	void calculateLIC7_returnsFalse_whenPointsAtDistanceLessThanLength1() {
		Point[] points = {
			new Point(3, 3),
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
			new Point(19, 12) // Distance is ~18.36
		};
		parameters.LENGTH_1 = 19;

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 7));
	}
	
	/**
	 * Test that calculateLIC7 returns false if K_PTS > (numPoints - 2)
	 */
	@Test
	void calculateLIC7_returnsFalse_whenKPtsGreaterThanNumpointsMinus2() {
		Point[] points = {
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
		};

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 7));
	}

	/**
	 * Test that calculateLIC7 returns false if K_PTS < 1
	 */
	@Test
	void calculateLIC7_returnsFalse_whenKPtsLessThan1() {
		Point[] points = {
			new Point(3, 3),
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
			new Point(105, 105) // Distance is ~144.25
		};

		ParameterStruct localParameters = new ParameterStruct();
		localParameters.K_PTS = 0;
		localParameters.LENGTH_1 = 1;
		assertFalse(LicHelper.calculateLIC(localParameters, points.length, points, 7));
	}

	/**
	 * Test that calculateLIC7 returns true if one set of K_PTS separated points
	 * is at a distance less than LENGTH_1, but another set is not
	 */
	@Test
	void calculateLIC7_returnsTrue_whenOneSetOfPointsAtDistanceGreaterThanLength1() {
		Point[] points = {
			new Point(3, 3),
			new Point(8, 8),
			new Point(0, 0),
			new Point(0, 0),
			new Point(4, 4), // Distance is 1
			new Point(44, 22) // Distance is ~38.63
		};
		parameters.LENGTH_1 = 35;

		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 7));
	}
}
