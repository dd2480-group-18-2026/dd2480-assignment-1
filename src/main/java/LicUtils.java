/**
 * Contains all helper methods for all of the calculateLICX methods.
 */
public final class LicUtils {
    private LicUtils() {
        //No instatiation of this class. Only static helper methods.
    }

    //Helper methods:

    static double distToLine(Point a, Point b, Point p) {
        // Based on the wikipedia page: https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line
        double abx = b.x - a.x;
        double aby = b.y - a.y;

        double num = Math.abs(
            aby * p.x - abx * p.y + b.x * a.y - b.y * a.x
        );
        double denom = Math.hypot(abx, aby);

        return num / denom;
    }

    static double pointDistance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
