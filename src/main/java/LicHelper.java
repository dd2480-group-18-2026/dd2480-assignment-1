import java.util.Arrays;

public class LicHelper {
    public static boolean calculateLIC(ParameterStruct parameters, int numPoints, Point[] points, int numOfLIC) {
        if (parameters == null) {
            throw new IllegalArgumentException("The parameters must not be null");
        } else if (points == null) {
            throw new IllegalArgumentException("The points must not be null");
        }

        switch (numOfLIC) {
            case 0:
                return calculateLIC0(points, parameters);
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return false;
            case 4:
                return calculateLIC4(parameters, numPoints, points);
            case 5:
                return false;
            case 6:
                return false;
            case 7:
                return false;
            case 8:
                return false;
            case 9:
                return false;
            case 10:
                return false;
            case 11:
                return false;
            case 12:
                return false;
            case 13:
                return false;
            case 14:
                return false;
            default:
                return false;
        }
    }

    private static boolean calculateLIC0(Point[] points, ParameterStruct parameters) {
        double length1 = parameters.LENGTH_1;

        for (int i = 0; i < points.length - 1; i++) {
            Point pointA = points[i];
            Point pointB = points[i + 1];

            if (pointA.distanceTo(pointB) > length1) {
                return true;
            }
        }
        return false;
    }

    private static boolean calculateLIC4(ParameterStruct parameters, int numPoints, Point[] points) {
        int QUADS = parameters.QUADS;
        int Q_PTS = parameters.Q_PTS;

        if (Q_PTS < 2 || Q_PTS > numPoints || QUADS < 1 || QUADS > 3) {
            return false;
        }

        boolean[] filledQuadrants = {false, false, false, false};

        int i = 0;

        // For each possible starting point in `points`
        while (i < numPoints - Q_PTS) {

            // We examine the sequence of length Q_PTS
            for (int j = 0; j < Q_PTS ; j++) {
                Point point = points[i + j];
                
                if (point.x >= 0 && point.y >= 0) { 
                    // First quadrant
                    filledQuadrants[0] = true;
                } else if (point.x < 0 && point.y >= 0) { 
                    // Second quadrant
                    filledQuadrants[1] = true;
                } else if (point.x <= 0 && point.y < 0) { 
                    // Third quadrant
                    filledQuadrants[2] = true;
                } else { 
                    // Fourth quadrant
                    filledQuadrants[3] = true;
                }
            }

            int count = 0;
            for (boolean quadrant: filledQuadrants) {
                if (quadrant) {
                    count++;
                }
            }

            if (count >= QUADS) { 
                // If the LIC is verified we return
                return true;
            } else { 
                // Otherwise we reset filledQuadrants
                Arrays.fill(filledQuadrants, false);
            }

            i++;
        }

        return false;
    }
}
