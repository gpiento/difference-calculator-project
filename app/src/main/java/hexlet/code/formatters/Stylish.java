package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatStylish(List<Map<String, Object>> data) {

        StringBuilder builder = new StringBuilder("{\n");

        for (Map<String, Object> map : data) {
            switch (map.get("type").toString()) {
                case "unchange" -> {
                    builder.append(String.format("    %s: %s\n", map.get("key"), map.get("value1")));
                }
                case "add" -> {
                    builder.append(String.format("  + %s: %s\n", map.get("key"), map.get("value1")));
                }
                case "remove" -> {
                    builder.append(String.format("  - %s: %s\n", map.get("key"), map.get("value1")));
                }
                case "change" -> {
                    builder.append(String.format("  - %s: %s\n", map.get("key"), map.get("value1")));
                    builder.append(String.format("  + %s: %s\n", map.get("key"), map.get("value2")));
                }
                default -> {
                    throw new RuntimeException("Unknown type: " + map.get("type"));
                }
            }
        }

        return builder.append("}\n").toString();
    }

    private static String stringify(Object value) {

        if (value == null) {
            return "null";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }

        return value.toString();
    }
}
