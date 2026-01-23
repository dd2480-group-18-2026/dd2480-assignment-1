import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic9Tests {
    @Test
    void returnsFalse_whenNumPointsLessThanFive() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0)
        };

        assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }

    @Test
    void returnsTrue_forAngleLessThanPiMinusEpsilon() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;

        // The angle Cetween these three points is 90°
        Point[] points = {
            new Point(0, 1),   // A
            new Point(0, 0),
            new Point(1, 1),   // vertex
            new Point(2, 1),
            new Point(1, 2)    // C
        };

        assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }

    @Test
    void returnsTrue_forAngleMoreThanPiPlusEpsilon() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;

        // The angle Cetween these three points is 270°
        Point[] points = {
            new Point(0, 0),   // A
            new Point(1, 0),
            new Point(2, 0),   // vertex
            new Point(2, 1),
            new Point(2, -1)    // C
        };

        assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }

    @Test
    void returnsFalse_forAngleExactlyPi() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;

        Point[] points = {
            new Point(0, 0),   // A
            new Point(1, 0),
            new Point(2, 0),   // vertex
            new Point(3, 0),
            new Point(4, 0)    // C
        };

        assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }

    @Test
    void returnsFalse_forAngleWithinEpsilonOfPi() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;

        Point[] points = {
            new Point(0, 0),        // A
            new Point(1, 0),
            new Point(2, 0),        // vertex
            new Point(3, 0),
            new Point(4, 1e-7)      // C
        };

        assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }

    @Test
    void returnsFalse_whenFirstPointEqualsVertex() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;

        Point[] points = {
            new Point(1, 1),   // A == vertex
            new Point(0, 0),
            new Point(1, 1),   // vertex
            new Point(2, 1),
            new Point(3, 1)
        };

        assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }

    @Test
    void returnsFalse_whenLastPointEqualsVertex() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;

        Point[] points = {
            new Point(0, 0),   // A
            new Point(1, 0),
            new Point(2, 0),   // vertex
            new Point(2, 1),
            new Point(2, 0)    // C == vertex
        };

        assertFalse(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }

    void returnsTrue_ifAnyTripletIsCorrect() {
        ParameterStruct parameters = new ParameterStruct();
        parameters.EPSILON = 1e-6;
        parameters.C_PTS = 1;
        parameters.D_PTS = 1;

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),   // A
            new Point(0, 0),   // collinear (invalid) for first
            new Point(3, 0),   // vertex
            new Point(3, 1),   
            new Point(4, 1),   // C
        };

        assertTrue(LicHelper.calculateLIC(parameters, points.length, points, 9));
    }
}
