package hexlet.code;

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
}
