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
    void tooFewNumPoints() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 1, 1), points.length, points, 8));
    }

    @Test
    void tooFewAPts() {
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
    void tooFewBPts() {
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
    void spacingTooLarge() {
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
    void distanceGreaterThanDiameter() {
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
    void distanceWithinDiameter() {
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
    void distanceEqualsDiameter() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(4, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(2.0, 1, 1), points.length, points, 8));
    }
}
