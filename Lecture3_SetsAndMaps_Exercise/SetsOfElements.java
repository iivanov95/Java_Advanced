package Lecture3_SetsAndMaps_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firstSet.add(scanner.nextLine());
        }
        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextLine());
        }
        firstSet.retainAll(secondSet);
        for (String s : firstSet) {
            System.out.print(s + " ");
        }
    }
}