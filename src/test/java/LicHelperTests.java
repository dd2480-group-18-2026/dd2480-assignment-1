import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LicHelperTests {
	@Test
	void calculateLIC_invalidParameters() {
		assertThrows(IllegalArgumentException.class, () -> {
			Point[] points = { new Point(0, 0) };
			LicHelper.calculateLIC(null, 0, points, 0);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			ParameterStruct parameters = new ParameterStruct();
			LicHelper.calculateLIC(parameters, 0, null, 0);
		});
	}
}
