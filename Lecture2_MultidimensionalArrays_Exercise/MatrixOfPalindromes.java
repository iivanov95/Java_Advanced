package Lecture2_MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[r][c];

        fillPalindromeMatrix(matrix);
        printMatrix(matrix);
    }

    private static void fillPalindromeMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String outsideSymbol = String.valueOf((char) ('a' + row));
                String midSymbol = String.valueOf((char) ('a' + row + col));
                matrix[row][col] = outsideSymbol + midSymbol + outsideSymbol;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}