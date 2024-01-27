package Lecture8_IteratorsAndComparatorsExercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class MainIterator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackIterator stackIterator = new StackIterator();

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            if ("Pop".equals(command)) {
                try {
                    stackIterator.pop();
                } catch (IllegalStateException exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (command.equals("Push")) {
                Arrays.stream(scanner.nextLine().split("[\\s,]+"))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .forEach(stackIterator::push);
            }
            line = scanner.nextLine();
        }
        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);
    }
}