package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String formatPlain(List<Map<String, Object>> data) {

        StringBuilder builder = new StringBuilder();

        for (Map<String, Object> map : data) {
            switch (map.get("type").toString()) {
                case "add" -> {
                    builder.append(String
                            .format("Property '%s' was added with value: %s\n", map.get("key"),
                                    stringify(map.get("value1"))));
                }
                case "remove" -> {
                    builder.append(String
                            .format("Property '%s' was removed\n",
                                    stringify(map.get("key"))));
                }
                case "change" -> {
                    builder.append(String
                            .format("Property '%s' was updated. From %s to %s\n", map.get("key"),
                                    stringify(map.get("value1")),
                                    stringify(map.get("value2"))));
                }
                default -> {
                    builder.append("");
                }
            }
        }
        return builder.toString();
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
