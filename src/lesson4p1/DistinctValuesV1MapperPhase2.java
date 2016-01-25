package lesson4p1;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class DistinctValuesV1MapperPhase2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String category = text.split(",")[1];
            System.out.println(category + "\t" + 1);
        }
    }
}
