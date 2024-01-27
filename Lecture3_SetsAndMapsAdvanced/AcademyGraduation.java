package Lecture3_SetsAndMapsAdvanced;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> nameGradeMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");
            double sumGrades = 0;
            for (int j = 0; j < grades.length; j++) {
                sumGrades += Double.parseDouble(grades[j]);
            }
            double averageGrade = sumGrades / grades.length;
            nameGradeMap.put(name, averageGrade);
        }
        for (Map.Entry<String, Double> entry : nameGradeMap.entrySet()) {
            BigDecimal averageGrade = BigDecimal.valueOf(entry.getValue()).stripTrailingZeros();
            System.out.printf("%s is graduated with %f%n", entry.getKey(), averageGrade);
        }
    }
}