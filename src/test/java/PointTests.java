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
}
