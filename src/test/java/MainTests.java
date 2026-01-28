import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MainTests {
    /*
     * This tests that the program returns YES when LICs 0, 3, 4, 5, 9, 10, 11 and 14
     * all evaluate to true and the rest are not considered given the LCM and PUV.
     */
    @Test
    void run_returnsTrue_whenCorrectConditions() {
        String jsonPath = "src/test/resources/test1.json";

        boolean launch = Main.run(jsonPath);

        assertTrue(launch);
    }

    /*
     * This tests that even when LICs evaluate to false, the program returns YES
     * when the LCM renders them irrelevant through NOTUSED being set across
     * the whole row.
     */
    @Test
    void run_returnsTrue_whenWholeLcmIsNotUsed() {
        String jsonPath = "src/test/resources/test2.json"; 

        boolean launch = Main.run(jsonPath);

        assertTrue(launch);
    }

    /*
     * This tests that the program returns false when LIC 4 evaluates to false
     * and it should be considered according to both the LCM and PUV.
     */
    @Test
	void run_returnsFalse_whenLic4IsNotMet() {
        String jsonPath = "src/test/resources/test3.json"; 

        boolean launch = Main.run(jsonPath);

        assertFalse(launch);
    }

    /*
     * This tests that the program returns false when the same inputs are given
     * as in the test run_returnsTrue_whenWholeLcmIsNotUsed except for 
     * another LCM.
     */
    @Test
	void run_returnsFalse_whenOnlyOnePointAndLcmIsNotAllNotUsed() {
		String jsonPath = "src/test/resources/test4.json"; 

        boolean launch = Main.run(jsonPath);

        assertFalse(launch);
	}

    /*
     * This tests that an IllegalArgumentExcetion is thrown when the dimensions
     * of the LCM are 16 by 16 (i.e. not 15 by 15, which it should be).
     */
    @Test
    void run_throwsIllegalArgumentException_whenLcmHasWrongDimensions() {
        String jsonPath = "src/test/resources/test5.json"; 

        assertThrows(IllegalArgumentException.class, () -> {
			Main.run(jsonPath);
		});
    }

    /*
     * This tests that an IllegalArgumentExcetion is thrown when the dimensions
     * of the LCM are 16 by 16 (i.e. not 15 by 15, which it should be).
     */
    @Test
    void run_throwsIllegalArgumentException_whenPuvHasWrongDimensions() {
        String jsonPath = "src/test/resources/test6.json"; 

        assertThrows(IllegalArgumentException.class, () -> {
			Main.run(jsonPath);
		});
    }
}
