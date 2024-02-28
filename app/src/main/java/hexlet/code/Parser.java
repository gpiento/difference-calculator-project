package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String data, String formatFile) throws Exception {

        switch (formatFile) {
            case "json" -> {
                return Parser.textToJson(data);
            }
            case "yaml", "yml" -> {
                return Parser.textToYaml(data);
            }
            default -> throw new Exception("Unknown file format: '" + formatFile + "'.");
        }
    }

    public static Map<String, Object> textToJson(String data) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }

    public static Map<String, Object> textToYaml(String data) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }
}
