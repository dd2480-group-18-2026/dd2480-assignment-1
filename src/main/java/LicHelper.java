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
                return calculateLIC1(points, numPoints, parameters);
            case 2:
                return calculateLIC2(parameters, numPoints, points);
            case 3:
                return calculateLIC3(points, parameters);
            case 4:
                return calculateLIC4(parameters, numPoints, points);
            case 5:
                return calculateLIC5(numPoints, points);
            case 6:
                return calculateLIC6(parameters, numPoints, points);
            case 7:
                return calculateLIC7(parameters, numPoints, points);
            case 8:
                return calculateLIC8(parameters, numPoints, points);
            case 9:
                return calculateLIC9(parameters, numPoints, points);
            case 10:
                return calculateLIC10(parameters, numPoints, points);
            case 11:
                return calculateLIC11(parameters, numPoints, points);
            case 12:
                return calculateLIC12(parameters, numPoints, points);
            case 13:
                return calculateLIC13(parameters, numPoints, points);
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

            if (LicUtils.pointDistance(pointA, pointB) > length1) {
                return true;
            }
        }
        return false;
    }

    private static boolean calculateLIC1(Point[] points, int numPoints, ParameterStruct parameters) {
        double R = parameters.RADIUS_1;

        if (numPoints < 3) {
            return false;
        }

        for (int i = 0; i < numPoints - 2; i++) {
            Point A = points[i];
            Point B = points[i + 1];
            Point C = points[i + 2];

            double ab = LicUtils.pointDistance(A, B);
            double bc = LicUtils.pointDistance(B, C); 
            double ca = LicUtils.pointDistance(C, A);

            double longest = Math.max(ab, Math.max(bc, ca));
            if (longest > 2 * R) {
                return true;
            }

            double area = LicUtils.calculateTriangleArea(A, B, C);

            double requiredRadius = LicUtils.calculateRequiredRadius(area, longest, ab, bc, ca);

            if (requiredRadius > R) {
                return true;
            }

        }

        return false;
    }
	private static boolean calculateLIC2(ParameterStruct parameters, int numPoints, Point[] points) {
		double epsilon = parameters.EPSILON;
		if (numPoints < 3) {
			return false;
		}

		for (int i = 0; i < numPoints - 2; i++) {
			Point A = points[i];
			Point B = points[i + 1];
			Point C = points[i + 2]; 

			if ((A.equals(B)) || (C.equals(B))) {
                continue;
            }

			double angle = LicUtils.angle(A, B, C);

			if ((angle < Math.PI - epsilon) || (angle > Math.PI + epsilon)) {
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

            double area = LicUtils.calculateTriangleArea(pointA, pointB, pointC);

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


    private static boolean calculateLIC5(int numPoints, Point[] points) {
        for (int i = 0; i < numPoints - 1; i++) {
            Point pointA = points[i];
            Point pointB = points[i + 1];
            if (pointB.x < pointA.x) {
                return true;
            }
        }
        return false;
    }

    private static boolean calculateLIC6(ParameterStruct parameters, int numPoints, Point[] points) {
        int N_PTS = parameters.N_PTS;
        double DIST = parameters.DIST;

        if (numPoints < 3 || N_PTS < 3 || DIST < 0)
            return false;

        for (int i = 0; i <= numPoints - N_PTS; i++) {
            
            //Initialise first and last point
            Point a = points[i];
            Point b = points[i + N_PTS - 1];

            //If a & b are the same point (exception)
            if (a.x == b.x && a.y == b.y) {
                //compare Euclidean distance from a to each interior point
                for (int j = i + 1; j < i + N_PTS - 1; j++) {
                    if (LicUtils.pointDistance(a, points[j]) > DIST) return true;
                }
            } else { // a and b are different points (common case)
                for (int j = i + 1; j < i + N_PTS - 1; j++) {
                    //compare perpendicular distance from the line through a and b to points[j]
                    if (LicUtils.distToLine(a, b, points[j]) > DIST) return true;
                }
            }
        } 
        return false;
    }

	private static boolean calculateLIC7(ParameterStruct parameters, int numPoints, Point[] points) {
		int kPts = parameters.K_PTS;
		double length = parameters.LENGTH_1;

		if (numPoints < 3 || kPts < 1 || kPts > (numPoints - 2)) {
			return false;
		}

		for (int i = 0; i < numPoints - (kPts + 1); i++) {
			if (LicUtils.pointDistance(points[i], points[i + kPts + 1]) > length) {
				return true;
			}
		}

		return false;
	}

    private static boolean calculateLIC8(ParameterStruct parameters, int numPoints, Point[] points) {
        int A_PTS = parameters.A_PTS;
        int B_PTS = parameters.B_PTS;
        double R = parameters.RADIUS_1;

        if (numPoints < 5) {
            return false;
        }
        if (A_PTS < 1) {
            return false;
        }
        if (B_PTS < 1) {
            return false;
        }
        if (A_PTS + B_PTS > numPoints - 3) {
            return false;
        }

        for (int i = 0; i < numPoints - (A_PTS + B_PTS + 2); i++) {
            Point A = points[i];
            Point B = points[i + A_PTS + 1];
            Point C = points[i + A_PTS + B_PTS + 2];

            double ab = LicUtils.pointDistance(A, B);
            double bc = LicUtils.pointDistance(B, C); 
            double ca = LicUtils.pointDistance(C, A);

            double longest = Math.max(ab, Math.max(bc, ca));
            if (longest > 2 * R) {
                return true;
            }

            double area = LicUtils.calculateTriangleArea(A, B, C);

            double requiredRadius = LicUtils.calculateRequiredRadius(area, longest, ab, bc, ca);

            if (requiredRadius > R) {
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

            double angle = LicUtils.angle(A, B, C);

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
            
            double triangleArea = LicUtils.calculateTriangleArea(pointA, pointB, pointC);
            if (triangleArea > area1) {
                return true;
            }
        }
        return false;
    }
  
    private static boolean calculateLIC11(ParameterStruct parameters, int numPoints, Point[] points) {
        if (numPoints < 3)
            return false;

        int G_PTS = parameters.G_PTS;

        for (int i = 0; i <= numPoints - G_PTS - 2; i++) {
            
            int j = i + G_PTS + 1;
            
            if (points[j].x - points[i].x < 0) return true;
        }
        return false;
    }

	private static boolean calculateLIC12(ParameterStruct parameters, int numPoints, Point[] points) {
		int kPts = parameters.K_PTS;
		double length1 = parameters.LENGTH_1;
		double length2 = parameters.LENGTH_2;

		if (numPoints < 3 || kPts < 1 || kPts > (numPoints - 2) ||length1 < 0 || length2 < 0) {
			return false;
		}

		boolean greaterThanLength1 = false;
		boolean lessThanLength2 = false;

		for (int i = 0; i < numPoints - (kPts + 1); i++) {
			if (LicUtils.pointDistance(points[i], points[i + kPts + 1]) > length1) {
				greaterThanLength1 = true;
			}
			if (LicUtils.pointDistance(points[i], points[i + kPts + 1]) < length2) {
				lessThanLength2 = true;
			}

			if (greaterThanLength1 && lessThanLength2) {
				return true;
			}
		}

		return false;
	}
  
    private static boolean calculateLIC13(ParameterStruct parameters, int numPoints, Point[] points) {
        int A_PTS = parameters.A_PTS;
        int B_PTS = parameters.B_PTS;
        double r1 = parameters.RADIUS_1;
        double r2 = parameters.RADIUS_2;

        if (numPoints < 5) {
            return false;
        }
        if (A_PTS < 1) {
            return false;
        }
        if (B_PTS < 1) {
            return false;
        }
        if (A_PTS + B_PTS > numPoints - 3) {
            return false;
        }

        boolean outsideCircle1 = false;
        boolean insideCircle2 = false;

        for (int i = 0; i < numPoints - (A_PTS + B_PTS + 2); i++) {
            Point A = points[i];
            Point B = points[i + A_PTS + 1];
            Point C = points[i + A_PTS + B_PTS + 2];

            double ab = LicUtils.pointDistance(A, B);
            double bc = LicUtils.pointDistance(B, C); 
            double ca = LicUtils.pointDistance(C, A);

            double longest = Math.max(ab, Math.max(bc, ca));

            double area = LicUtils.calculateTriangleArea(A, B, C);

            double requiredRadius = LicUtils.calculateRequiredRadius(area, longest, ab, bc, ca);

            if (requiredRadius > r1) {
                outsideCircle1 = true;
            }
            if (requiredRadius <= r2) {
                insideCircle2 = true;
            }
            if (outsideCircle1 && insideCircle2) {
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

            double area = LicUtils.calculateTriangleArea(pointA, pointB, pointC);

            if (area > area1) condition1 = true;

            if (area < area2) condition2 = true;

            if (condition1 && condition2) return true;
        }

        return condition1 && condition2;
    }
}
