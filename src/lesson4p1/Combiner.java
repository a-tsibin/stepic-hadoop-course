package lesson4p1;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class Combiner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        long sum = 0;
        long count = 0;
        Long[] data = new Long[2];
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = text.split("\t");
            String key = keyValue[0];
            data[0] = Long.parseLong(keyValue[1].split(";")[0]);
            data[1] = Long.parseLong(keyValue[1].split(";")[1]);
            if (prevKey != null && !key.equals(prevKey)) {
                System.out.println(prevKey + "\t" + sum + ";" + count);
                sum = data[0];
                count = data[1];
            } else {
                sum += data[0];
                count += data[1];
            }
            prevKey = key;
        }

        if (prevKey != null) {
            System.out.println(prevKey + "\t" + sum + ";" + count);
        }
    }
}
