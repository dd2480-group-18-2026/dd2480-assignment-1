import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic2Tests {

	@Test 
	void returnsTrue_forAngleLessThanPiMinusEpsilon() {
		ParameterStruct parameters = new ParameterStruct();
		parameters.EPSILON = 0.1; 
		
		Point[] points = {
			// The angle between these points is 225°
			new Point(0, 1), // A
			new Point(0, 2), // B
			new Point(-1, 3), // C
		};

		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}

	@Test 
	void returnsTrue_forAngleGreaterThanPiMinusEpsilon() {
		ParameterStruct parameters = new ParameterStruct();
		parameters.EPSILON = 0.1; 
		
		Point[] points = {
			// The angle between these points is ~63,43°
			new Point(0, 1), // A
			new Point(0, 0), // B
			new Point(2, 1), // C
		};

		assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 2));
	}
}


