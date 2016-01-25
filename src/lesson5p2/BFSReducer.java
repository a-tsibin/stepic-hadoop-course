package lesson5p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class BFSReducer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prevKey = null;
        int minDistance = Integer.MAX_VALUE;
        List<String> adjacentVertices = new ArrayList<>();
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] keyValues = text.split("\t");
            String key = keyValues[0];
            String distance = keyValues[1];
            if (prevKey != null && !key.equals(prevKey)) {
                formattedOutput(prevKey, minDistance, adjacentVertices);
                adjacentVertices.clear();
                minDistance = Integer.MAX_VALUE;
            }
            if (!distance.equals("INF") && Integer.parseInt(distance) < minDistance) {
                minDistance = Integer.parseInt(distance);
            }
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(keyValues[2]);
            while (m.find()) {
                adjacentVertices.add(m.group());
            }
            prevKey = key;
        }

        if (prevKey != null) {
            formattedOutput(prevKey, minDistance, adjacentVertices);
        }
    }

    private static void formattedOutput(String key, int minDistance, List<String> adjacentVertices) {
        String distance;
        if (minDistance == Integer.MAX_VALUE)
            distance = "INF";
        else
            distance = String.valueOf(minDistance);
        System.out.println(key + "\t" + distance + "\t{" + String.join(",", adjacentVertices) + "}");
    }
}
