package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Formatter.compareMap;
import static hexlet.code.Formatter.selectFormat;
import static hexlet.code.Parser.parse;

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
        List<Map<String, Object>> comparedList = compareMap(mapReadValue1, mapReadValue2);

        return selectFormat(comparedList, formatOutput);
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
}
