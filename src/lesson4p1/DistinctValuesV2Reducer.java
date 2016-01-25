package lesson4p1;

import java.util.*;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class DistinctValuesV2Reducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        Map<String, Integer> map = new HashMap<>();
        Set<String> categories = new HashSet<>();
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = text.split("\t");
            String key = keyValue[0];
            String value = keyValue[1];
            if (prevKey != null && !key.equals(prevKey)) {
                merge(map, categories);
                categories.clear();
                categories.add(value);
            } else {
                categories.add(value);
            }
            prevKey = key;
        }

        if (prevKey != null) {
            merge(map, categories);
        }

        map.forEach((key, value) -> System.out.println(key + "\t" + value));
    }

    private static <T> void merge(Map<T, Integer> map, Set<T> set) {
        set.forEach((category) -> map.put(category, map.getOrDefault(category, 0) + 1));
    }
}
