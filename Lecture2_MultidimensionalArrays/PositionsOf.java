package Lecture2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int c = 0; c < columns; c++) {
                matrix[r][c] = arr[c];
            }
        }

        int specialValue = Integer.parseInt(scanner.nextLine());

        boolean valueIsFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                int currentElement = matrix[row][column];
                if (currentElement == specialValue) {
                    System.out.println(row + " " + column);
                    valueIsFound = true;
                }
            }
        }
        if (!valueIsFound) {
            System.out.println("not found");
        }
    }
}