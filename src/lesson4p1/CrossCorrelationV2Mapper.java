package lesson4p1;

import java.util.*;

/**
 * Created by Andrew Tsibin https://github.com/Evilnef.
 */
public class CrossCorrelationV2Mapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            Set<String> uniqueElements = new HashSet<>();
            for (String element : elements) {
                if (uniqueElements.contains(element))
                    continue;
                uniqueElements.add(element);
                Map<String, Integer> stripe = new HashMap<>();
                int freq = 0;
                for (String secondElement : elements) {
                    if (secondElement.equals(element)) {
                        freq++;
                        continue;
                    }
                    stripe.put(secondElement, stripe.getOrDefault(secondElement, 0) + 1);
                }
                scaleStripe(stripe, freq);
                printStripe(element, stripe);
            }
        }
    }

    private static void scaleStripe(Map<String, Integer> stripe, int factor) {
        stripe.forEach((key, value) -> stripe.put(key, stripe.get(key) * factor));
    }

    private static void printStripe(String obj, Map<String, Integer> stripe) {
        System.out.print(obj + "\t");
        final String[] separator = {""};
        stripe.forEach((key, value) -> {
            System.out.print(separator[0] + key + ":" + value);
            separator[0] = ",";
        });
        System.out.println();
    }
}
