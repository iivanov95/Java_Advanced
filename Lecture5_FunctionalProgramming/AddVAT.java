package Lecture5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prices with VAT:");

        Function<String, Double> parsePriceAddVAT = a -> Double.parseDouble(a) * 1.2;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(parsePriceAddVAT)
                .forEach(v -> System.out.printf("%.2f%n", v));
    }
}
