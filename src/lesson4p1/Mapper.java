package lesson4p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            for (String term : text.split(" ")) {
                map.put(term, 1 + map.getOrDefault(term, 0));
            }
        }
        map.forEach((k,v) -> System.out.println(k + "\t" + v));
    }
}
