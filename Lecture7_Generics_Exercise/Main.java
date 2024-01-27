package Lecture7_Generics_Exercise;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        CustomList<String> customList = new CustomList<>();

        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String el : customList) {
                        System.out.println(el);
                    }
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }

            line = scanner.nextLine();
        }

    }
    static <T extends Comparable<T>> int countGreaterElements(List<T> data, T element) {
        int count = 0;
        for (T e : data) {
            int result = e.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }
    static <T> void swap (List<T> list, int index1, int index2) {
        T firstElement = list.get(index1);
        T secondElement = list.get(index2);
        list.set(index1, secondElement);
        list.set(index2, firstElement);
    }
}