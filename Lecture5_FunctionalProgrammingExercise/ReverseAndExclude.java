package Lecture5_FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isDivisibleByN = number -> number % n == 0;
        Collections.reverse(numbers);
        numbers.removeIf(isDivisibleByN);
        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));
        print.accept(numbers);
    }
}