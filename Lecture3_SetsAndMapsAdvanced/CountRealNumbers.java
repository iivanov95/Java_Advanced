package Lecture3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        String[] numbersArr = input.split("\\s+");
        for (int i = 0; i < numbersArr.length; i++) {
            double currentNum = Double.parseDouble(numbersArr[i]);
            if (numbersMap.containsKey(currentNum)) {
                numbersMap.put(currentNum, numbersMap.get(currentNum) + 1);
            } else {
                numbersMap.put(currentNum, 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}