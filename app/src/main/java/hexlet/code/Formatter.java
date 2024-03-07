package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> data, String formatType) throws Exception {

        switch (formatType) {
            case "plain" -> {
                return Plain.format(data);
            }
            case "stylish" -> {
                return Stylish.format(data);
            }
            case "json" -> {
                return Json.format(data);
            }
            default -> throw new Exception("Unknown format.");
        }
    }
}
