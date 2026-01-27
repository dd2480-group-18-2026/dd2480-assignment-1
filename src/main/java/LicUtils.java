/**
 * Contains all helper methods for all of the calculateLICX methods.
 */
public final class LicUtils {
    private LicUtils() {
        //No instatiation of this class. Only static helper methods.
    }

    //Helper methods:

    static double distToLine(Point a, Point b, Point p) {
        //Using the point-to-line distance formula: |(B-A) x (P-A)| / |B-A|.
        double abx = b.x - a.x;
        double aby = b.y - a.y;

        double apx = p.x - a.x;
        double apy = p.y - a.y;

        double cross = abx * apy - aby * apx;
        double abLen = Math.hypot(abx, aby);

        return Math.abs(cross) / abLen;
    }

    static double pointDistance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
