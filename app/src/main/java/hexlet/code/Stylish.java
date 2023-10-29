package hexlet.code;

import java.util.Map;
import java.util.TreeMap;

public class Stylish {

    public static String render(Map<String, Object> mapReadValue1, Map<String, Object> mapReadValue2) {

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
}
