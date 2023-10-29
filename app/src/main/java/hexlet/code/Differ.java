package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(final String filePath1,
                                  final String filePath2,
                                  final String fileFormat) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapReadValue1 = objectMapper.readValue(readFile(filePath1), Map.class);
        Map<String, Object> mapReadValue2 = objectMapper.readValue(readFile(filePath2), Map.class);

        switch (fileFormat) {
            case "plain" -> {
                return Plain.render(mapReadValue1, mapReadValue2);
            }
            case "stylish" -> {
                return Stylish.render(mapReadValue1, mapReadValue2);
            }
            case "json" -> {
                return Json.render(mapReadValue1, mapReadValue2);
            }
            default -> {
                return "Unknown format.";
            }
        }
    }

    public static String generate(final String filePath1, final String filePath2) {
        generate(filePath1, filePath2, "stylish");
    }

    public static String readFile(final String fileName) {

        Path filePath = Paths.get(fileName).toAbsolutePath().normalize();
        String dataJson;

        try {
            dataJson = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dataJson;
    }
}
