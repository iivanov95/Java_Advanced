package Lecture3_SetsAndMaps_Exercise;

import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> types = Map.of("S", 4,
                "H", 3,
                "D", 2,
                "C", 1);
        Map<String, Integer> powers = new HashMap<>(Map.of("2", 2,
                "3", 3,
                "4", 4,
                "5", 5,
                "6", 6,
                "7", 7,
                "8", 8,
                "9", 9,
                "10", 10,
                "J", 11));

        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);

        Map<String, Set<String>> players = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");
            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            for (String card : cards) {
                players.get(name).add(card);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            String playerName = entry.getKey();
            int points = calculatePoints(entry.getValue(), types, powers);
            System.out.printf("%s: %d\n", playerName, points);
        }
    }

    private static int calculatePoints(Set<String> cards,
                                       Map<String, Integer> types,
                                       Map<String, Integer> powers) {
        int points = 0;
        for (String card : cards) {
            String cardPower = card.substring(0, card.length() - 1);
            String type = String.valueOf(card.charAt(card.length() - 1));

            points += powers.get(cardPower) * types.get(type);
        }

        return points;
    }
}