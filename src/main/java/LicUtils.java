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

	static double angle(Point A, Point B, Point C) {
		double BA_angle = Math.atan2(A.y - B.y, A.x - B.x);
		double BC_angle = Math.atan2(C.y - B.y, C.x - B.x);

		double angle = BA_angle - BC_angle;
		return angle;
    }

    static double calculateTriangleArea(Point A, Point B, Point C) {
        double area = Math.abs(
                (A.x * (B.y - C.y) +
                 B.x * (C.y - A.y) +
                 C.x * (A.y - B.y)) / 2.0
            );
        return area;
    }

    static double calculateRequiredRadius(double area, double longest, double ab, double bc, double ca) {
        double requiredRadius;
        if (area == 0.0) {
                requiredRadius = longest / 2.0;
            } 
        else {
            double rCircumradius = (ab * bc * ca) / (4.0 * area);
            double rLongestSide = longest / 2.0;
            requiredRadius = Math.max(rLongestSide, rCircumradius);
        }
        return requiredRadius;
    }

}
