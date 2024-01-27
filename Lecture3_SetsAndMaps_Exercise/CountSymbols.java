package Lecture3_SetsAndMaps_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                int currentValue = map.get(currentChar);
                map.put(currentChar, currentValue + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}