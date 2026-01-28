import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Lic12Tests {
	private final static ParameterStruct parameters = new ParameterStruct();
	@BeforeAll
	static void init() {
		parameters.LENGTH_1 = 5;
		parameters.LENGTH_2 = 10;
		parameters.K_PTS = 2;
	}

	/**
	 * Test that calculateLIC12 returns true if 2 points separated by K_PTS are at a distance greater than LENGTH_1 
	 * and less than LENGTH_2
	 */
	@Test
	void calculateLIC12_returnsTrue_whenSamePointsAtDistanceGreaterThanLength1AndLessThanLength2() {
		Point[] points = {
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
			new Point(5, 5) // Distance is ~7.07
		};

		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 12));
	}

	/**
	 * Test that calculateLIC12 returns true if 2 points separated by K_PTS are at a distance greater than LENGTH_1 
	 * and less than LENGTH_2
	 */
	@Test
	void calculateLIC12_returnsTrue_whenDifferentPointsAtDistanceGreaterThanLength1AndLessThanLength2() {
		Point[] points = {
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
			new Point(33, 33), // Distance is ~46.67
			new Point(3, 1) // Distance is ~3.16
		};
		
		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 12));
	}

	/**
	 * Test that calculateLIC12 returns false if no 2 points are at a distance less than LENGTH_2
	 */
	@Test
	void calculateLIC12_returnsFalse_whenNoPointsAtDistanceLessThanLength2() {
		Point[] points = {
			new Point(0, 0),
			new Point(9, 9),
			new Point(0, 0),
			new Point(33, 33), // Distance is ~46.67
			new Point(9, 100) // Distance is 91
		};

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 12));
	}

	/**
	 * Test that calculateLIC12 returns false if no 2 points are at a distance greater than LENGTH_1
	 */
	@Test
	void calculateLIC12_returnsFalse_whenNoPointsAtDistanceGreaterThanLength1() {
		Point[] points = {
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
			new Point(3, 3), // Distance is ~4.24
			new Point(3, 1) // Distance is ~3.16
		};
		
		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 12));
	}
	
	/**
	 * Test that calculateLIC12 returns false if K_PTS > (numPoints - 2)
	 */
	@Test
	void calculateLIC12_returnsFalse_whenKPtsGreaterThanNumpointsMinus2() {
		Point[] points = {
			new Point(0, 0),
			new Point(0, 0),
			new Point(0, 0),
		};

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 12));
	}

	/**
	 * Test that calculateLIC12 returns false if K_PTS < 1
	 */
	@Test
	void calculateLIC12_returnsFalse_whenKPtsLessThan1() {
		Point[] points = {
			new Point(3, 3),
			new Point(0, 0),
			new Point(0, 0),
			new Point(105, 105), // Distance is ~144.25
			new Point(0, 0) // Distance is 0
		};

		ParameterStruct localParameters = new ParameterStruct();
		localParameters.K_PTS = 0;
		localParameters.LENGTH_1 = 10;
		localParameters.LENGTH_2 = 10;
		assertFalse(LicHelper.calculateLIC(localParameters, points.length, points, 12));
	}

	/**
	 * Test that calculateLIC12 returns false if LENGTH1 < 0
	 */
	@Test
	void calculateLIC12_returnsFalse_whenLength1Negative() {
		Point[] points = {
			new Point(3, 3),
			new Point(0, 0),
			new Point(0, 0),
			new Point(105, 105), // Distance is ~144.25
			new Point(0, 0) // Distance is 0
		};

		ParameterStruct localParameters = new ParameterStruct();
		localParameters.K_PTS = 0;
		localParameters.LENGTH_1 = -10;
		localParameters.LENGTH_2 = 10;
		assertFalse(LicHelper.calculateLIC(localParameters, points.length, points, 12));
	}

	/**
	 * Test that calculateLIC12 returns false if LENGTH2 < 0
	 */
	@Test
	void calculateLIC12_returnsFalse_whenLength2Negative() {
		Point[] points = {
			new Point(3, 3),
			new Point(0, 0),
			new Point(0, 0),
			new Point(105, 105), // Distance is ~144.25
			new Point(0, 0) // Distance is 0
		};

		ParameterStruct localParameters = new ParameterStruct();
		localParameters.K_PTS = 0;
		localParameters.LENGTH_1 = 10;
		localParameters.LENGTH_2 = -10;
		assertFalse(LicHelper.calculateLIC(localParameters, points.length, points, 12));
	}
}
