import java.io.File;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class InputParser {
    public ParameterStruct parameters;
    public Point[] points;
    public Connectors[][] LCM;
    public boolean[] PUV;


    public InputParser(String jsonUrl) {
        File jsonFile = new File(jsonUrl);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        this.parameters = objectMapper.treeToValue(
            rootNode.get("parameters"), 
            ParameterStruct.class
        );

        this.points = objectMapper.treeToValue(
            rootNode.get("points"),
            Point[].class
        );

        this.LCM = objectMapper.treeToValue(
            rootNode.get("LCM"),
            Connectors[][].class
        );

        this.PUV = objectMapper.treeToValue(
            rootNode.get("PUV"),
            boolean[].class
        );
    }
}
