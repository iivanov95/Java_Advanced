package Lecture5_FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        Predicate<String> isLongerThanLength = str -> str.length() <= length;
        Arrays.stream(scanner.nextLine().split("\\s+"))
                        .filter(isLongerThanLength)
                        .forEach(System.out::println);
    }
}
