package lesson4p1;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class DistinctValuesV1MapperPhase1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValue = new String[2];
            keyValue[0] = text.split("\t")[0];
            keyValue[1] = text.split("\t")[1];
            for (String category : keyValue[1].split(",")) {
                System.out.println(keyValue[0].concat(",").concat(category) + "\t" + 1);
            }
        }
    }
}
