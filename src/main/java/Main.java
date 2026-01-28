public class Main {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("No problem file specified, aborting...");
			System.exit(1);
		}

		String jsonPath = args[0];
		
		boolean launch = run(jsonPath);

		System.out.println(launch ? "YES" : "NO");

		System.exit(0);
	}

	public static boolean run(String jsonPath) {
		InputParser inputParser = new InputParser(jsonPath);

		return Interceptor.decide(inputParser.points.length, inputParser.points, inputParser.parameters, inputParser.LCM, inputParser.PUV);
	}
}
