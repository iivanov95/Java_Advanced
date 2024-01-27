package Lecture3_SetsAndMaps_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, String> nameMap = new LinkedHashMap<>();

        while (!line.equals("stop")) {
            String name = line;
            String email = scanner.nextLine();
            if (!email.contains(".us") && !email.contains(".uk") && !email.contains(".com")) {
                nameMap.put(name, email);
            }
            line = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : nameMap.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}