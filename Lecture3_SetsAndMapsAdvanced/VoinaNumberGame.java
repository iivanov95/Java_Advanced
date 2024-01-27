package Lecture3_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds-- > 0) {
            int firstCard = firstDeck.iterator().next(); //първа карта първи дек
            firstDeck.remove(firstCard);
            int secondCard = secondDeck.iterator().next();// първа карта втори дек
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (firstCard < secondCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        String output;
        if (firstDeck.size() > secondDeck.size()) {
            output = "First player win!";
        } else if (firstDeck.size() < secondDeck.size()){
            output = "Second player win!";
        } else {
            output = "Draw!";
        }
        System.out.println(output);
    }
}