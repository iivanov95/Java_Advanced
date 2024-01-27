package Lecture2_MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[3][3];
        int count = 1;
        fillMatrix(matrix, count);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, int count) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = count;
                count++;
            }
        }
    }
}