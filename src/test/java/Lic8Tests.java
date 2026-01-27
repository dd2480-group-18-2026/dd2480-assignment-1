import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic8Tests {

    private static ParameterStruct params(double radius1, int aPts, int bPts) {
        return new ParameterStruct(
            0,
            0,
            radius1,
            0,
            0,
            0,
            0,
            0,
            0,
            aPts,
            bPts,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0
        );
    }

    @Test
    void calculateLIC8_returnsFalse_ToFewPoints() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 1, 1), points.length, points, 8));
    }

    @Test
    void calculateLIC8_returnsFalse_tooFewAPts() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 0, 1), points.length, points, 8));
    }

    @Test
    void calculateLIC8_returnsFalse_tooFewBPts() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 1, 0), points.length, points, 8));
    }

    @Test
    void calculateLIC8_returnsFalse_spacingTooLarge() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(4, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 2, 1), points.length, points, 8));
    }

    @Test
    void calculateLIC8_returnsTrue_distanceGreaterThanDiameter() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(10, 0)
        };
        assertTrue(LicHelper.calculateLIC(params(1.0, 1, 1), points.length, points, 8));
    }

    @Test
    void calculateLIC8_returnsFalse_distanceWithinDiameter() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3),
            new Point(4, 4)
        };
        assertFalse(LicHelper.calculateLIC(params(10.0, 1, 1), points.length, points, 8));
    }

    @Test
    void calculateLIC8_returnsFalse_distanceEqualsDiameter() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(4, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(2.0, 1, 1), points.length, points, 8));
    }

    @Test
    void calculateLIC8_returnsTrue_distanceWithinDiameterButStillFails() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(4, 0),
            new Point(0, 0),
            new Point(8, 0)
        };

        assertTrue(LicHelper.calculateLIC(params(3.0, 1, 1), points.length, points, 8));
    }
}
