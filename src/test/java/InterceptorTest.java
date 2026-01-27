import static org.junit.jupiter.api.Assertions.assertEquals;

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

        String result = Interceptor.decide(points.length, points, PARAMETERS, LCM, PUV);

        assertEquals("YES", result);
	}

    @Test
	void decide_returnsTrue_whenWholeLcmIsNotUsed() {
		Point[] points = {
            new Point(-2, 3),
        };

        String result = Interceptor.decide(points.length, points, PARAMETERS, LCM_ALL_NOTUSED, PUV);

        assertEquals("YES", result);
	}

    @Test
	void decide_returnsFalse_whenOnlyOnePointAndLcmIsNotAllNotUsed() {
		Point[] points = {
            new Point(-2, 3),
        };

        String result = Interceptor.decide(points.length, points, PARAMETERS, LCM, PUV);

        assertEquals("NO", result);
	}
}
