package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(final String filePath1, final String filePath2) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapReadValue1 = objectMapper.readValue(readJson(filePath1), Map.class);
        Map<String, Object> mapReadValue2 = objectMapper.readValue(readJson(filePath2), Map.class);


        StringBuilder diff = new StringBuilder("{\n");

        TreeMap<String, Object> commonMap = new TreeMap<>(mapReadValue1);
        commonMap.putAll(mapReadValue2);

        for (Map.Entry<String, Object> entry : commonMap.entrySet()) {
            String key = entry.getKey();
            Object value1 = mapReadValue1.get(key);
            Object value2 = mapReadValue2.get(key);

            if (value1 == null) {
                diff.append(String.format("  + %s: %s%n", key, value2));
            } else if (value2 == null) {
                diff.append(String.format("  - %s: %s%n", key, value1));
            } else if (!value1.equals(value2)) {
                diff.append(String.format("  - %s: %s%n", key, value1));
                diff.append(String.format("  + %s: %s%n", key, value2));
            } else {
                diff.append(String.format("    %s: %s%n", key, value1));
            }
        }
        diff.append("}\n");

        return diff.toString();
    }

    public static String readJson(final String fileName) {

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
