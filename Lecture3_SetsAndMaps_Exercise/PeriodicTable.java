package Lecture3_SetsAndMaps_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }
        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}