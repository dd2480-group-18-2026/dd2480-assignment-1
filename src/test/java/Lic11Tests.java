import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic11Tests {
    @Test
	void calculateLIC11_returnsTrue_minimal() {
		ParameterStruct parameters = new ParameterStruct(
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
			1, //Only one "consecutive" point
			0, 
			0, 
			0 
		);

		Point[] points = {
            new Point(2,0),
            new Point(0,0),
            new Point(1,0)
        };

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 11);

		assertTrue(result);
	}
    
    @Test
	void calculateLIC11_returnsFalse_minimal() {
		ParameterStruct parameters = new ParameterStruct(
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
			1, //Only one "consecutive" point
			0, 
			0, 
			0 
		);

		Point[] points = {
            new Point(2,0),
            new Point(0,0),
            new Point(3,0)
        };

		boolean result = LicHelper.calculateLIC(parameters, points.length, points, 11);

		assertFalse(result);
	}

}
