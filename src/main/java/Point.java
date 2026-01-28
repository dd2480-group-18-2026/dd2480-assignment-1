import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * Simple 2-D point class
 */
public class Point {
	public final double x; 
	public final double y;

	@JsonCreator
    public Point(
        @JsonProperty("x") double x,
        @JsonProperty("y") double y
    ) {
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
}
