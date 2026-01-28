public class Main {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("No problem file specified, aborting...");
			System.exit(1);
		}

		String jsonPath = args[0];
		InputParser inputParser = new InputParser(jsonPath);

		// System.out.println("Points: " + inputParser.points.length);
		// System.out.println("LCM null? " + (inputParser.LCM == null));
		// System.out.println("PUV null? " + (inputParser.PUV == null));

		// if (inputParser.LCM != null) {
		// 	System.out.println("LCM size: " + inputParser.LCM.length + " x " + inputParser.LCM[0].length);
		// }

		// if (inputParser.PUV != null) {
		// 	System.out.println("PUV length: " + inputParser.PUV.length);
		// }

		boolean launch = Interceptor.decide(inputParser.points.length, inputParser.points, inputParser.parameters, inputParser.LCM, inputParser.PUV);

		if (launch) System.out.println("YES");
		else System.out.println("NO");

		System.exit(0);
	}
}
