import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Lic2Tests {

	private static ParameterStruct parameters = new ParameterStruct();

	@BeforeAll
	static void init() {
		parameters.EPSILON = 0.0001; 
	}

	/**
	 * This test asserts that calculateLIC2 returns false if there
	 * are not enough points
	 */
	@Test 
	void returnsFalse_whenLessThanThreePoints() {
		Point[] points = {
			new Point(0, -1), // A
			new Point(0, 1), // B
		};

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}

	/**
	 * This test asserts that calculateLIC2 returns true if angle fufills
	 * the condition angle > PI + epsilon
	 */
	@Test 
	void returnsTrue_forAngleGreaterThanPiPlusEpsilon() {
		Point[] points = {
			// The angle between these points is 225°
			new Point(0, 1), // A
			new Point(0, 2), // B
			new Point(-1, 3), // C
		};

		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}

	/**
	 * This test asserts that calculateLIC2 returns true if angle fufills
	 * the condition angle < PI - epsilon
	 */
	@Test 
	void returnsTrue_forAngleLessThanPiMinusEpsilon() {
		Point[] points = {
			// The angle between these points is ~63,43°
			new Point(0, 1), // A
			new Point(0, 0), // B
			new Point(2, 1), // C
		};
		
		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}

	/**
	 * This test asserts that calculateLIC2 returns false if the angle is exactly PI
	 * 
	 * As angle must be > PI + epsilon or < PI - epsilon having an angle of 
	 * exactly PI should return false.
	 * 
	 * (Unless epsilon is negative)
	 */
	@Test 
	void returnsFalse_forAngleExactlyPiWhenEpsilonIsPositive() {
		Point[] points = {
            new Point(0, 0),   // A
            new Point(2, 0),   // vertex
            new Point(4, 0)    // C
        };

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}

	/**
	 * This test asserts that calculateLIC2 returns false
	 * if the first point coincides with the vertex
	 */
	@Test 
	void returnsFalse_forFirstPointCoincideWithVertex() {
		Point[] points = {
			new Point(0, 0), // A
			new Point(0, 0), // B
			new Point(1, 1), // C
		};

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}

	/**
	 * This test asserts that calculateLIC2 returns false
	 * if the last point coincides with the vertex
	 */
	@Test 
	void returnsFalse_forLastPointCoincideWithVertex() {
		Point[] points = {
			new Point(0, 0), // A
			new Point(1, 1), // B
			new Point(1, 1), // C
		};

		assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}

	/**
	 * This test asserts that calculateLIC2 returns true 
	 * if one set of three consecutive points
	 * fufills the condition, but some do not.
	 */
	@Test 
	void returnsTrue_ifAnyTripletIsCorrect() {
		Point[] points = {
            new Point(1, 0),   // A
            new Point(0, 0),   // collinear (invalid) for first
            new Point(3, 0),   // vertex
            new Point(4, 1),   // C
        };

		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}
}