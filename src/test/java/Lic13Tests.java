import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Lic13Tests {

    private static ParameterStruct params(double radius1, double radius2, int aPts, int bPts) {
        return new ParameterStruct(
            0,
            0,
            radius1,
            radius2,
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
    void calculateLIC13_returnsFalse_ToFewPoints() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 2.0, 1, 1), points.length, points, 13));
    }

    @Test
    void calculateLIC13_returnsFalse_tooFewAPts() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 2.0, 0, 1), points.length, points, 13));
    }

    @Test
    void calculateLIC13_returnsFalse_tooFewBPts() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 2.0, 1, 0), points.length, points, 13));
    }

    @Test
    void calculateLIC13_returnsFalse_spacingTooLarge() {
        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(4, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 2.0, 2, 1), points.length, points, 13));
    }

    @Test
    void calculateLIC13_returnsFalse_onlyOutsideCircle1() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(0, 0),
            new Point(10, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(1.0, 0.5, 1, 1), points.length, points, 13));
    }

    @Test
    void calculateLIC13_returnsFalse_onlyInsideCircle2() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(0, 0),
            new Point(2, 0)
        };
        assertFalse(LicHelper.calculateLIC(params(100.0, 2.0, 1, 1), points.length, points, 13));
    }

    @Test
    void calculateLIC13_returnsTrue_outsideCircle1_andInsideCircle2() {
        Point[] points = {
            new Point(0, 0),
            new Point(0, 0),
            new Point(10, 0),
            new Point(0, 0),
            new Point(20, 0)
        };
        assertTrue(LicHelper.calculateLIC(params(5.0, 20.0, 1, 1), points.length, points, 13));
    }
}
