package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parser(String data, String formatType) {

        /*switch (formatType) {
            case "plain" -> {
                return Plain.render(fileMap1, fileMap2);
            }
            case "stylish" -> {
                return Stylish.render(fileMap1, fileMap2);
            }
            case "json" -> {
                return Json.render(fileMap1, fileMap2);
            }
            default -> {
                return "Unknown format.";
            }
        }*/

        return new HashMap<>();
    }

    public static Map<String, Object> textToJson(String data) throws JsonProcessingException {

        if (data == null) {
            return new HashMap<>();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }

    public static Map<String, Object> textToYaml(String data) throws JsonProcessingException {

        if (data == null) {
            return new HashMap<>();
        }

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        return objectMapper.readValue(data, new TypeReference<>() {
        });
    }
}
