package Lecture2_MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[n][n];

        switch (pattern) {
            case "A":
                fillPatternA(matrix);
                break;
            case "B":
                fillPatternB(matrix);
                break;
        }
        printMatrixPatternA(matrix);
    }

    private static void fillPatternB(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            if ((col + 1) % 2 != 0) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
    }

    private static void printMatrixPatternA(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static void fillPatternA(int[][] matrix) {
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = count;
                count++;
            }
        }
    }
}
