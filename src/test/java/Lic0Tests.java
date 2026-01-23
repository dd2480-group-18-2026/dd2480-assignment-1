import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic0Tests {
    private final static ParameterStruct parameters = new ParameterStruct(
			2, 
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
			0, 
			0, 
			0
		);

    @Test
	void calculateLIC0_returnsTrue_whenConsecutivePointsHaveDistanceGreaterThanLength1() {
		Point[] points = {new Point(0, 1), new Point(1, 1), new Point(5, 6)};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 0);

		assertTrue(result);
	}
	
	@Test
	void calculateLIC0_returnsFalse_whenNoConsecutivePointsHaveDistanceGreaterThanLength1() {
		Point[] points = {new Point(0, 1), new Point(1, 1), new Point(2, 1)};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 0);

		assertFalse(result);
	}

	@Test
	void calculateLIC0_returnsFalse_whenOnlyOnePoint() {
		Point[] points = {new Point(0, 1)};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 0);

		assertFalse(result);
	} 
}
