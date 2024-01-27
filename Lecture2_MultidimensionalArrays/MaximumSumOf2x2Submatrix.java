package Lecture2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int currentElement = matrix[r][c];
                int right = matrix[r][c + 1];
                int down = matrix[r + 1][c];
                int downAndRight = matrix[r + 1][c + 1];
                int sum = currentElement + right + down + downAndRight;
                if (maxSum < sum) {
                    maxSum = sum;
                    maxMatrix[0][0] = currentElement;
                    maxMatrix[0][1] = right;
                    maxMatrix[1][0] = down;
                    maxMatrix[1][1] = downAndRight;
                }
            }
        }
        System.out.println(maxMatrix[0][0] + " " + maxMatrix[0][1]);
        System.out.println(maxMatrix[1][0] + " " + maxMatrix[1][1]);
        System.out.println(maxSum);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[0];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}