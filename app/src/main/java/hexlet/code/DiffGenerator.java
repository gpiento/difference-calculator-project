package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffGenerator {

    public static List<Map<String, Object>> generator(Map<String, Object> map1, Map<String, Object> map2) {

        List<Map<String, Object>> listMaps = new ArrayList<>();
        Set<String> setKeys = new TreeSet<>(map1.keySet());
        setKeys.addAll(map2.keySet());

        for (String key : setKeys) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (!map2.containsKey(key)) {
                map.put("key", key);
                map.put("type", "remove");
                map.put("value1", map1.get(key));
            } else if (!map1.containsKey(key)) {
                map.put("key", key);
                map.put("type", "add");
                map.put("value1", map2.get(key));
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                map.put("key", key);
                map.put("type", "change");
                map.put("value1", map1.get(key));
                map.put("value2", map2.get(key));
            } else {
                map.put("key", key);
                map.put("type", "unchange");
                map.put("value1", map1.get(key));
            }

            listMaps.add(map);
        }

        return listMaps;
    }

}
