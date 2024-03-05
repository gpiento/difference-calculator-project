package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> data, String formatType)
            throws JsonProcessingException {

        switch (formatType) {
            case "plain" -> {
                return Plain.formatPlain(data);
            }
            case "stylish" -> {
                return Stylish.formatStylish(data);
            }
            case "json" -> {
                return Json.formatJson(data);
            }
            default -> {
                try {
                    throw new Exception("Unknown format.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
