package lesson4p2;

import java.util.Scanner;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class UrlMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String url = text.split("\t")[2];
            System.out.println(url);
        }
    }
}
