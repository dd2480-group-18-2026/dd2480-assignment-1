import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic5Tests {
	private final static ParameterStruct parameters = new ParameterStruct();

	@Test
	void calculateLIC5_returnsTrue_whenNextPointXGreaterThanCurrentPointX() {
		Point[] points = {new Point(0, 0), new Point(-1, 0)};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 5);

		assertTrue(result);
	}

	@Test
	void calculateLIC5_returnsFalse_whenNextPointXNotGreaterThanCurrentPointX() {
		Point[] points = {new Point(0, 0), new Point(0, 0), new Point(0, 1)};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 5);

		assertFalse(result);
	}
	
	@Test
	void calculateLIC5_returnsFalse_whenOnlyOnePoint() {
		Point[] points = {new Point(0, 0)};

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 5);

		assertFalse(result);
	}
}
