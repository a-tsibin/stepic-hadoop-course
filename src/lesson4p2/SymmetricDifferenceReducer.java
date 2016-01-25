package lesson4p2;

import java.util.*;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class SymmetricDifferenceReducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        Map<String, List<String>> values = new HashMap<>();
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = text.split("\t");
            String key = keyValue[0];
            if (prevKey != null && !key.equals(prevKey)) {
                printMap(prevKey, values);
                values.clear();
            }
            String tag = keyValue[1].split(":")[0];
            String value = keyValue[1].split(":")[1];
            if (!values.containsKey(tag)) {
                values.put(tag, new ArrayList<>());
            }
            values.get(tag).add(value);
            prevKey = key;
        }

        if (prevKey != null) {
            printMap(prevKey, values);
        }
    }

    private static void printMap(String user, Map<String, List<String>> map) {
        final String targetKey1 = "query";
        final String targetKey2 = "url";

        if (!(map.containsKey(targetKey1) && map.containsKey(targetKey2)))
            return;

        for (String v1 : map.get(targetKey1)) {
            for (String v2 : map.get(targetKey2)) {
                System.out.println(user + "\t" + v1 +"\t" + v2);
            }
        }
    }
}
