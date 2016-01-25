package lesson4p1;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class Reducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        long sum = 0;
        long count = 0;
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = text.split("\t");
            String key = keyValue[0];
            long value = Long.parseLong(keyValue[1]);
            if (prevKey != null && !key.equals(prevKey)) {
                System.out.println(prevKey + "\t" + sum / count);
                sum = value;
                count = 1;
            } else {
                sum += value;
                count++;
            }
            prevKey = key;
        }

        if (prevKey != null) {
            System.out.println(prevKey + "\t" + sum / count);
        }
    }
}
