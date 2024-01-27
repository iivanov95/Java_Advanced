package Lecture3_SetsAndMaps_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("search")) {
            String[] data = command.split("-");
            String name = data[0];
            String number = data[1];
            phonebook.put(name, number);
            command = scanner.nextLine();
        }
        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")) {
            if (phonebook.containsKey(searchName)) {
                System.out.printf("%s -> %s\n", searchName, phonebook.get(searchName));
            } else {
                System.out.println("Contact " + searchName + " does not exist.");
            }
            searchName = scanner.nextLine();
        }
    }
}
