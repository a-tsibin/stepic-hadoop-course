package lesson5p3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class PageRankMapper {
    public static void main(String[] args) {
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
            double pageRank = Double.parseDouble(keyValues[1]) / adjacentVertices.size();
            adjacentVertices.forEach(v -> System.out.println(v + "\t" + new DecimalFormat("#0.000").format(pageRank) + "\t{}"));
        }
    }
}
