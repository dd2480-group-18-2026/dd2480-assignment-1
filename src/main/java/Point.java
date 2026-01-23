/** 
 * Simple 2-D point class
 */
public class Point {
	public final double x; 
	public final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Point)) return false;
		Point p = (Point) o;
		return x == p.x && y == p.y;
	}

	/**
	 * This methods compute the absolute value of the ABC angle
	 * using the calling point as the vertex
	 * @param A The first point of the triplet
	 * @param C The last point of the triplet
	 * @return The absolute value of the ABC angle in radians
	 */
	public double angle(Point A, Point C) {
		double BA_angle = Math.atan2(A.y - y, A.x - x);
		double BC_angle = Math.atan2(C.y - y, C.x - x);

		double angle = BA_angle - BC_angle;
		return Math.abs(angle);
	}
}
