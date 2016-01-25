package lesson4p3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class Job1Mapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String docId = line.split(":")[0];
            String text = line.split(":", 2)[1];
            Pattern p = Pattern.compile("[\\w']+");
            Matcher matcher = p.matcher(text);
            while (matcher.find()) {
                System.out.println(text.substring(matcher.start(), matcher.end()) + "#" + docId + "\t" + 1);
            }
        }
    }
}
