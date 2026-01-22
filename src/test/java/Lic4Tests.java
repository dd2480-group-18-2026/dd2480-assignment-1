import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic4Tests {
    @Test
	void calculateLIC4_positive() {
		ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			3, // 3 quadrants required
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
			4 // In 4 consecutive points
		);

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

	@Test
	void calculateLIC4_negative() {
		ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			3, // Testing 3 quadrants required
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
			8 // In 8 consecutive points
		);

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

    @Test
	void calculateLIC4InvalidQUADS() {
		ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			6, // Testing 6 quadrants required (obviously impossible)
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
			8 // In 8 consecutive points
		);

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

    @Test
	void calculateLIC4InvalidQPTS() {
		ParameterStruct parameters = new ParameterStruct(
			0,
			0, 
			0, 
			0, 
			0, 
			0, 
			0, 
			2, // Testing 2 quadrants required
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
			20 // In 20 consecutive points (there are only 10 points)
		);

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
}
