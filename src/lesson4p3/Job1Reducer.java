package lesson4p3;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class Job1Reducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        int count = 0;
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = text.split("\t");
            String key = keyValue[0];
            if (prevKey != null && !key.equals(prevKey)) {
                System.out.println(prevKey.split("#")[0] + "\t" + prevKey.split("#")[1] + "\t" + count);
                count = 1;
            } else {
                count++;
            }
            prevKey = key;
        }

        if (prevKey != null) {
            System.out.println(prevKey.split("#")[0] + "\t" + prevKey.split("#")[1] + "\t" + count);
        }
    }
}
