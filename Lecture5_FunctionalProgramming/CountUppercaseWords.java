package Lecture5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] words = text.split("\\s+");

        Predicate<String> isUpperCase = s -> Character.isUpperCase(s.charAt(0));
        Function<String[], List<String>> getUpperCaseWords = arr -> Arrays.stream(arr)
                .filter(isUpperCase)
                .collect(Collectors.toList());
        List<String> upperCase = getUpperCaseWords.apply(words);
        System.out.println(upperCase.size());
        Consumer<String> outputConsumer = s -> System.out.println(s);
        upperCase.forEach(outputConsumer);
    }
}