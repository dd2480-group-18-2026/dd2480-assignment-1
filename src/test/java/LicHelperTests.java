import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class LicHelperTests {
	@Test
	void TestLicExample() {
		LicHelper helper = new LicHelper();
	}

	@Test
	void calculateLIC_returnsFalse() {
		boolean result = LicHelper.calculateLIC(null, 0, null, 0);

		assertFalse(result);
	}
}
