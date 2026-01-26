import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PointTests {
    /**
     * This test asserts if the "equals" override works as expected
     * for the point structure.
     */
    @Test
    void point_coordinateEquality() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);

        assertTrue(p1.equals(p2));
    }

    /**
     * This test asserts whether the calculation for angles below 180°
     * is correct. 
     * Here, the angle between the X-axis and the BA vector is 180°, 
     * and the angle between the X-axis and the BC vector is 45°,
     * for a total of 135°.
     */
    @Test
    void pointAngle_returnsCorrectValueForAngleBelow180() {
        Point A = new Point(0, 0);
        Point vertex = new Point(2, 0);
        Point C = new Point(4, 2);

        assertEquals(135, vertex.angle(A, C) * 180 / Math.PI);
    }
    
    /**
     * This test asserts whether the calculation for angles above 180°
     * is correct. 
     * Here, the angle between the X-axis and the BA vector is 180°, 
     * and the angle between the X-axis and the BC vector is -135°,
     * for a total of 180 - (-135) = 315°. This should then be changed
     * back to 360 - 315 = 45°.
     */
    @Test
    void pointAngle_returnsCorrectValueForAngleAbove180() {
        Point A = new Point(0, 0);
        Point vertex = new Point(2, 0);
        Point C = new Point(1, -1);

        assertEquals(45, vertex.angle(A, C) * 180 / Math.PI);
    }
}
