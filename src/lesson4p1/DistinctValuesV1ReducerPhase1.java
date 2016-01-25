package lesson4p1;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class DistinctValuesV1ReducerPhase1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = text.split("\t");
            String key = keyValue[0];
            if (prevKey != null && !key.equals(prevKey)) {
                System.out.println(prevKey);
            }
            prevKey = key;
        }

        if (prevKey != null) {
            System.out.println(prevKey);
        }
    }
}
