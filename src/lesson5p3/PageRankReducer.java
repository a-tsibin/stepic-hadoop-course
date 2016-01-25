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
public class PageRankReducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        double pageRank = 0;
        List<String> adjacentVertices = new ArrayList<>();
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValues = text.split("\t");
            String key = keyValues[0];
            if (prevKey != null && !key.equals(prevKey)) {
                formattedOutput(prevKey, pageRank, adjacentVertices);
                adjacentVertices.clear();
                pageRank = 0;
            }
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(keyValues[2]);
            int adjacentVerticesCount = 0;
            while (m.find()) {
                adjacentVertices.add(m.group());
                adjacentVerticesCount++;
            }
            if (adjacentVerticesCount == 0)
                pageRank += Double.parseDouble(keyValues[1]);
            prevKey = key;
        }

        if (prevKey != null) {
            formattedOutput(prevKey, pageRank, adjacentVertices);
        }
    }

    private static void formattedOutput(String key, double pageRank, List<String> adjacentVertices) {
        System.out.println(key + "\t" + new DecimalFormat("#0.000").format(pageRank) + "\t{" + String.join(",", adjacentVertices) + "}");
    }
}
