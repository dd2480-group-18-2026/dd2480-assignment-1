import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InterceptorTest {
    static final ParameterStruct PARAMETERS = new ParameterStruct(
        2, 
        0, 
        0, 
        0, 
        1e-6, 
        1, 
        10, 
        2, 
        0, 
        1, 
        1, 
        1, 
        1, 
        1, 
        1, 
        1, 
        1, 
        1, 
        3
    );

    static final Connectors[][] LCM = {
        {Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.ANDD},
    };

    static final Connectors[][] LCM_ALL_NOTUSED = {
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
        {Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
    };

    static final boolean[] PUV = {true, false, false, true, true, true, false, false, false, true, true, true, true, false, true};

    /*
     * This tests that decide returns true when LICs 0, 3, 4, 5, 9, 10, 11 and 14
     * all evaluate to true and the rest are not considered given the LCM and PUV.
     */
    @Test
	void decide_returnsTrue_whenCorrectConditions() {
		Point[] points = {
            new Point(-2, 3),
            new Point(0, 0),
            new Point(1, -1),
            new Point(1, 2),
            new Point(3, 3),
            new Point(3, 4),
            new Point(5, 4),
            new Point(11, 10),
            new Point(13, 12),
            new Point(10, 17),
        };

        boolean result = Interceptor.decide(points.length, points, PARAMETERS, LCM, PUV);

        assertTrue(result);
	}

    /*
     * This tests that even when LICs evaluate to false, decide returns true
     * when the LCM renders them irrelevant through NOTUSED being set across
     * the whole row.
     */
    @Test
	void decide_returnsTrue_whenWholeLcmIsNotUsed() {
		Point[] points = {
            new Point(-2, 3),
        };

        boolean result = Interceptor.decide(points.length, points, PARAMETERS, LCM_ALL_NOTUSED, PUV);

        assertTrue(result);
	}

    /*
     * This tests that decide returns false when LIC 4 evaluates to false
     * and it should be considered according to both the LCM and PUV.
     */
    @Test
	void decide_returnsFalse_whenLic4IsNotMet() {
		Point[] points = {
            new Point(-2, 3),
            new Point(0, 0),
            new Point(1, 1),
            new Point(1, 2),
            new Point(3, 3),
            new Point(3, 4),
            new Point(5, 4),
            new Point(11, 10),
            new Point(13, 12),
            new Point(10, 17),
        };

        boolean result = Interceptor.decide(points.length, points, PARAMETERS, LCM, PUV);

        assertFalse(result);
	}

    /*
     * This tests that decide returns false when the same inputs are given
     * as in the test decide_returnsTrue_whenWholeLcmIsNotUsed except for 
     * another LCM.
     */
    @Test
	void decide_returnsFalse_whenOnlyOnePointAndLcmIsNotAllNotUsed() {
		Point[] points = {
            new Point(-2, 3),
        };

        boolean result = Interceptor.decide(points.length, points, PARAMETERS, LCM, PUV);

        assertFalse(result);
	}

    /*
     * This tests that an IllegalArgumentExcetion is thrown when the dimensions
     * of the LCM are 16 by 16 (i.e. not 15 by 15, which it should be).
     */
    @Test
    void decide_throwsIllegalArgumentException_whenLcmHasWrongDimensions() {
        Point[] points = {
            new Point(-2, 3),
        };
        Connectors[][] badLcm = new Connectors[16][16];

        assertThrows(IllegalArgumentException.class, () -> {
			Interceptor.decide(points.length, points, PARAMETERS, badLcm, PUV);
		});
    }

    /*
     * This tests that an IllegalArgumentExcetion is thrown when the length
     * of the PUV is 16 (i.e. not 15, which it should be).
     */
    @Test
    void decide_throwsIllegalArgumentException_whenPuvHasWrongDimensions() {
        Point[] points = {
            new Point(-2, 3),
        };
        boolean[] badPuv = new boolean[16];

        assertThrows(IllegalArgumentException.class, () -> {
			Interceptor.decide(points.length, points, PARAMETERS, LCM, badPuv);
		});
    }
}
