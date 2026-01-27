public class Main {
	public static void main(String[] args) {
		ParameterStruct PARAMETERS = new ParameterStruct(
			2, 
			0, 
			0, 
			0, 
			1e-6, 
			1, 
			10, 
			2, 
			0, 
			1, 
			1, 
			1, 
			1, 
			1, 
			1, 
			1, 
			1, 
			1, 
			3
		);

		Connectors[][] LCM = {
			{Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ORR, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.ANDD, Connectors.ANDD, Connectors.ORR, Connectors.ANDD, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED},
			{Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.NOTUSED, Connectors.ANDD},
		};

		boolean[] PUV = {true, false, false, true, true, true, false, false, false, true, true, true, true, false, true};

		Point[] points = {
            new Point(-2, 3),
            new Point(0, 0),
            new Point(1, -1),
            new Point(1, 2),
            new Point(3, 3),
            new Point(3, 4),
            new Point(5, 4),
            new Point(11, 10),
            new Point(13, 12),
            new Point(10, 17),
			new Point(-2, 3),
            new Point(0, 0),
            new Point(1, -1),
            new Point(1, 2),
            new Point(3, 3),
            new Point(3, 4),
            new Point(5, 4),
            new Point(11, 10),
            new Point(13, 12),
            new Point(10, 17),
			new Point(-2, 3),
            new Point(0, 0),
            new Point(1, -1),
            new Point(1, 2),
            new Point(3, 3),
            new Point(3, 4),
            new Point(5, 4),
            new Point(11, 10),
            new Point(13, 12),
            new Point(10, 17),
			new Point(-2, 3),
            new Point(0, 0),
            new Point(1, -1),
            new Point(1, 2),
            new Point(3, 3),
            new Point(3, 4),
            new Point(5, 4),
            new Point(11, 10),
            new Point(13, 12),
            new Point(10, 17),
			new Point(-2, 3),
            new Point(0, 0),
            new Point(1, -1),
            new Point(1, 2),
            new Point(3, 3),
            new Point(3, 4),
            new Point(5, 4),
            new Point(11, 10),
            new Point(13, 12),
            new Point(10, 17),
        };

		boolean result = Interceptor.decide(points.length, points, PARAMETERS, LCM, PUV);

		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		System.exit(0);
	}
}
