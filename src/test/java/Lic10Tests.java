import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class Lic10Tests {
    private final static ParameterStruct parametersArea1Is5 = new ParameterStruct();
	private final static ParameterStruct parametersArea1Is3 = new ParameterStruct();

	@BeforeAll
	static void init() {
		parametersArea1Is5.AREA_1 = 5;
		parametersArea1Is5.E_PTS = 1;
		parametersArea1Is5.F_PTS = 2;

		parametersArea1Is3.AREA_1 = 3;
		parametersArea1Is3.E_PTS = 1;
		parametersArea1Is3.F_PTS = 2;
	}

	/*
	 * Test that calculateLIC10 returns true when the following are true:
	 * 
	 * there exists three points that create a triangle with an area 
	 * that is greater than the parameter AREA1 
	 * 
	 * the first and the second point have E_POINTS between them
	 * 
	 * the second and the third point have F_POINTS between them
	 */
	@Test
	void calculateLIC10_returnsTrue_whenThreeConsecutiveInterveningPointsFulfilCriteria() {
		Point[] points = {
			new Point(2, 4), 
			new Point(1, 0), 
			new Point(2, 0), 
			new Point(3, 6), 
			new Point(4, 6),
			new Point(0, 0)
		};

		boolean result = LicHelper.calculateLIC(parametersArea1Is3, 6, points, 10);

		assertTrue(result);
	}

	@Test
	void calculateLIC10_returnsFalse_whenNumPointsLessThan5() {
		Point[] points = {
			new Point(2, 4), 
			new Point(1, 0), 
			new Point(2, 0), 
			new Point(0, 0)
		};

		boolean result = LicHelper.calculateLIC(parametersArea1Is3, 4, points, 10);

		assertFalse(result);
	}

	/*
	 * Test that calculateLIC10 returns false when the following are true:
	 * 
	 * there exists three points that create a triangle with an area 
	 * that is less than the parameter AREA1 
	 * 
	 * the first and the second point have E_POINTS between them
	 * 
	 * the second and the third point have F_POINTS between them
	 */
	@Test
	void calculateLIC10_returnsFalse_whenTriangleAreaLessThanArea1() {
		Point[] points = {
			new Point(2, 4), 
			new Point(1, 0), 
			new Point(2, 0), 
			new Point(3, 6), 
			new Point(4, 6),
			new Point(0, 0)
		};

		boolean result = LicHelper.calculateLIC(parametersArea1Is5, 6, points, 10);

		assertFalse(result);
	}
}
