package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(final String filePath1,
                                  final String filePath2,
                                  final String formatOutput) throws Exception {

        String data1 = getTextFromFile(filePath1);
        String data2 = getTextFromFile(filePath2);
        String extFile1 = FilenameUtils.getExtension(filePath1);
        String extFile2 = FilenameUtils.getExtension(filePath2);

        Map<String, Object> mapReadValue1 = parse(data1, extFile1);
        Map<String, Object> mapReadValue2 = parse(data2, extFile2);

        return mapReadValue1.toString() + "\n" + mapReadValue2.toString();
    }

    public static String generate(final String filePath1, final String filePath2) throws Exception {

        return generate(filePath1, filePath2, "stylish");
    }

    public static String getTextFromFile(final String fileName) throws Exception {

        Path filePath = getNormalizePath(fileName);

        if (!filePath.toFile().exists()) {
            throw new RuntimeException("File '" + fileName + "' not found.");
        }

        return Files.readString(filePath);
    }

    public static Path getNormalizePath(final String fileName) {

        return Paths.get(fileName).toAbsolutePath().normalize();
    }

    public static Map<String, Object> parse(String data, String formatType) throws Exception {

        switch (formatType) {
            case "json" -> {
                return Json.parser(data);
            }
            case "yaml" -> {
                return Yaml.parser(data);
            }
            default -> throw new Exception("Unknown format: '" + formatType + "'.");

        }
    }
}
