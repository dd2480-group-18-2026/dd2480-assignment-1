# DD2480 Assignment 1 – Launch Interceptor Conditions

This project implements the DECIDE algorithm specified in the Launch Interceptor Program requirements, evaluating radar data to decide whether to issue a launch command.

The system evaluates a set of geometric conditions based on input points and parameters to determine whether a launch decision should be made. Each LIC is implemented as a separate logical condition and verified using automated unit tests. The main focus of the project is correctness, testing, and collaborative software development practices.

## License
This project is licensed under the MIT License.
See the [LICENSE](LICENSE) file for details.

## Requirements

- Java 21
- Apache Maven

## Build and Run the Program

### Run tests
```bash
mvn test
```

### Build the Project
```bash
mvn package
```

### Run the Application
```bash
java -jar target/dd2480.decide-${VERSION}.jar path/to/input.json
```

### Input Format
The application expects a JSON file describing the DECIDE problem instance.

The JSON file should contain:
- LIC parameters
- A list of 2D points
- A Logical Connector Matrix (LCM)
- A Preliminary Unlocking Vector (PUV)

Example input files and the expected structure can be found in the test resources directory.

## Contributions
### August (GitHub: augustyvdal)
Implemented LIC3, LIC8 and LIC13.
Wrote README and License.
Reviewed several PRs.

### Felix (GitHub: seahoers)
Set up the GitHub organisation and repo. 
Implemented LIC0, LIC5 and LIC10. 
Implemented the initial version of the DECIDE method. 
Reviewed several PRs.

### Tobias (GitHub: tbengts)
Implemented LIC 1, 6 and 11.
Made a LicUtils class and refactored all calculateLIC methods to use it instead of using methods in the point class, and having some code duplication in other places.
Reviewed some PRs.

### Eliott (GitHub: Telmo26)
Setup the project structure.
Implemented LICs 4, 9 and 14.
Added parallelism to the decide function.
Implemented the JSON parsing function.
Reviewed several PRs.

### Tim (GitHub: Uniquepotatoes)
Implemented LIC 2, 7 and 12.
Refactored tests to be shorter and more consistent with less unneeded boilerplate, cleaned up existing tests.
Discussed implementation with other group members.
Reviewed several PRs.