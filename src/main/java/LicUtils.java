/**
 * Contains all helper methods for all of the calculateLICX methods.
 */
public final class LicUtils {
    private LicUtils() {
        //No instatiation of this class. Only static helper methods.
    }

    //Helper methods:

    static boolean pointsInCircle(Point a, Point b, Point c, double r) {
        double maxDist =
            Math.max(
                pointDistance(a, b),
                Math.max(
                    pointDistance(a, c),
                    pointDistance(b, c)
                )
        );
        return maxDist <= r * 2;
    }
    
    static double pointDistance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
