package lesson4p2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class IntersectionReducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        Set<String> setValues = new HashSet<>();
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = text.split("\t");
            String key = keyValue[0];
            if (prevKey != null && !key.equals(prevKey)) {
                if (setValues.size() == 1 && setValues.contains("A"))
                    System.out.println(prevKey);
                setValues.clear();
            }
            setValues.add(keyValue[1]);
            prevKey = key;
        }

        if (setValues.size() == 1 && setValues.contains("A")) {
            System.out.println(prevKey);
        }
    }
}
