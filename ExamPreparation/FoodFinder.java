package ExamPreparation;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] vowels = scanner.nextLine().replace(" ", "").toCharArray();
        char[] consonants = scanner.nextLine().replace(" ", "").toCharArray();

        Deque<Character> vowelsQueue = new ArrayDeque<>();
        Deque<Character> consonantsStack = new ArrayDeque<>();
        for (char vowel : vowels) {
            vowelsQueue.offer(vowel);
        }
        for (char consonant : consonants) {
            consonantsStack.push(consonant);
        }
        String[] words = new String[]{"pear", "flour", "pork", "olive"};

        while (!consonantsStack.isEmpty()) {
            String firstVowel = vowelsQueue.getFirst() + "";
            String firstConsonant = consonantsStack.getFirst() + "";
            for (int i = 0; i < words.length; i++) {
                String currentWord = words[i];
                if (currentWord.contains(firstVowel)) {
                    currentWord = words[i].replace(firstVowel, firstVowel.toUpperCase());
                }
                if (currentWord.contains(firstConsonant)) {
                    currentWord = words[i].replace(firstVowel, firstVowel.toUpperCase());
                }
            }
            vowelsQueue.offer(firstVowel.charAt(0));
            consonantsStack.pop();
        }
    }
}
