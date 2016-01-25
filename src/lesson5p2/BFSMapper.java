package lesson5p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class BFSMapper {
    public static void main(String[] args) {
        String inf = "INF";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] keyValues = line.split("\t");
            System.out.println(String.join("\t", keyValues));

            List<String> adjacentVertices = new ArrayList<>();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(keyValues[2]);
            while (m.find()) {
                adjacentVertices.add(m.group());
            }
            String distance;
            if (!keyValues[1].equals(inf))
                distance = String.valueOf(Integer.parseInt(keyValues[1]) + 1);
            else
                distance = keyValues[1];
            adjacentVertices.forEach(v -> System.out.println(v + "\t" + distance + "\t{}"));
        }
    }
}
