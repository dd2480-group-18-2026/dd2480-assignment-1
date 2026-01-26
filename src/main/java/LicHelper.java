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
                return calculateLIC3(points, parameters);
            case 4:
                return calculateLIC4(parameters, numPoints, points);
            case 5:
                return calculateLIC5(numPoints, points);
            case 6:
                return false;
            case 7:
                return false;
            case 8:
                return false;
            case 9:
                return calculateLIC9(parameters, numPoints, points);
            case 10:
                return calculateLIC10(parameters, numPoints, points);
            case 11:
                return false;
            case 12:
                return false;
            case 13:
                return false;
            case 14:
                return calculateLIC14(parameters, numPoints, points);
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

    private static boolean calculateLIC3(Point[] points, ParameterStruct parameters) { 
        if (points.length < 3) {
            return false;
        }
        
        for (int i = 0; i < points.length - 2; i++) {
            Point pointA = points[i];
            Point pointB = points[i + 1];
            Point pointC = points[i + 2];

            double area = Math.abs(
                (pointA.x * (pointB.y - pointC.y) +
                 pointB.x * (pointC.y - pointA.y) +
                 pointC.x * (pointA.y - pointB.y)) / 2.0
            );

            if (area > parameters.AREA_1) {
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

            if (count > QUADS) { 
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

    public static boolean calculateLIC5(int numPoints, Point[] points) {
        for (int i = 0; i < numPoints - 1; i++) {
            Point pointA = points[i];
            Point pointB = points[i + 1];
            if (pointB.x < pointA.x) {
                return true;
            }
        }
        return false;
    }
  
    private static boolean calculateLIC9(ParameterStruct parameters, int numPoints, Point[] points) {
        int C_PTS = parameters.C_PTS;
        int D_PTS = parameters.D_PTS;
        double epsilon = parameters.EPSILON;

        if ((numPoints < 5) || C_PTS == 0 || D_PTS == 0 || C_PTS + D_PTS > numPoints - 3) {
            return false;
        }

        for (int i = 0; i < numPoints - (C_PTS + D_PTS + 2); i++) {
            Point A = points[i];
            Point B = points[i + C_PTS + 1];
            Point C = points[i + C_PTS + D_PTS + 2];

            if ((A.equals(B)) || (C.equals(B))) {
                continue;
            }

            double angle = B.angle(A, C);

            if ((angle < Math.PI - epsilon) || (angle > Math.PI + epsilon)) {
                return true;
            }
        }
        return false;
    }

    private static boolean calculateLIC10(ParameterStruct parameters, int numPoints, Point[] points) {
        int ePoints = parameters.E_PTS;
        int fPoints = parameters.F_PTS;
        double area1 = parameters.AREA_1;
        
        for (int i = 0; i < numPoints - ePoints - fPoints - 2; i++) {
            Point pointA = points[i];
            Point pointB = points[i + ePoints + 1];
            Point pointC = points[i + ePoints + fPoints + 2];
            
            double triangleArea = 0.5 * Math.abs((pointB.x - pointA.x) * (pointC.y - pointA.y) - (pointC.x - pointA.x) * (pointB.y - pointA.y)); // Shoelace theorem
            if (triangleArea > area1) {
                return true;
            }
        }
        return false;
    }
  
    private static boolean calculateLIC14(ParameterStruct parameters, int numPoints, Point[] points) {
        // We get the required parameters from the struct
        double area1 = parameters.AREA_1;
        double area2 = parameters.AREA_2;

        if ((numPoints < 5) || area2 < 0) {
            return false;
        }

        int ePts = parameters.E_PTS;
        int fPts = parameters.F_PTS;

        // Both of these conditions need to be true for the LIC to be true
        boolean condition1 = false; // area > AREA_1
        boolean condition2 = false; // area < AREA_2

        for (int i = 0; i < numPoints - (ePts + fPts + 2); i++) {
            Point pointA = points[i];
            Point pointB = points[i + ePts + 1];
            Point pointC = points[i + ePts + fPts + 2];

            double area = Math.abs(
                (pointA.x * (pointB.y - pointC.y) +
                 pointB.x * (pointC.y - pointA.y) +
                 pointC.x * (pointA.y - pointB.y)) / 2.0
            );

            if (area > area1) condition1 = true;

            if (area < area2) condition2 = true;

            if (condition1 && condition2) return true;
        }

        return condition1 && condition2;
    }
}
