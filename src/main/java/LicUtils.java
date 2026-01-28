/**
 * Contains all helper methods for all of the calculateLICX methods.
 */
public final class LicUtils {
    private LicUtils() {
        //No instatiation of this class. Only static helper methods.
    }

    //Helper methods:
    
    static double pointDistance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
