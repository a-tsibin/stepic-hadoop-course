package lesson4p2;

import java.util.Scanner;

public class UsersFilter {
    public static void main(String[] args) {
        String targetUser = "user10";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            String[] splitedData = text.split("\t");
            if (splitedData[1].equals(targetUser))
                System.out.println(text);
        }
    }
}
