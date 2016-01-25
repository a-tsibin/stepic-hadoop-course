package lesson4p3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class Job2Reducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        String docId = "";
        String freq = "";
        Map<String, String> wordMap = new HashMap<>();
        int count = 0;
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValues = text.split("\t");
            String key = keyValues[0];
            docId = keyValues[1].split(";")[0];
            freq = keyValues[1].split(";")[1];
            if (prevKey != null && !key.equals(prevKey)) {
                for (String id : wordMap.keySet()) {
                    System.out.println(prevKey + "#" + id + "\t" + wordMap.get(id) + "\t" + count);
                }
                count = 1;
                wordMap.clear();
            } else {
                count++;
            }
            prevKey = key;
            wordMap.put(docId, freq);
        }

        if (prevKey != null) {
            for (String id : wordMap.keySet()) {
                System.out.println(prevKey + "#" + id + "\t" + wordMap.get(id) + "\t" + count);
            }
        }
    }
}
