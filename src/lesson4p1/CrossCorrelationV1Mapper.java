package lesson4p1;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class CrossCorrelationV1Mapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            for (String element : elements) {
                for (String secondElement : elements) {
                    if (secondElement.equals(element))
                        continue;
                    System.out.println(element.concat(",").concat(secondElement).concat("\t") + 1);
                }
            }
        }
    }
}
