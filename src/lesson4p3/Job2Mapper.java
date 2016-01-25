package lesson4p3;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class Job2Mapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] keyValues = line.split("\t");
            String word = keyValues[0];
            String docId = keyValues[1];
            String freq = keyValues[2];
            System.out.println(word + "\t" + docId + ";" + freq + ";" + 1);
        }
    }
}
