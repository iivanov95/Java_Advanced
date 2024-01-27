package Lecture2_MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][columns];
        char[][] secondMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            firstMatrix[row] = line.toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            secondMatrix[row] = line.toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char outputSumbol = '*';
                if (firstMatrix[row][column] == secondMatrix[row][column]) {
                    outputSumbol = firstMatrix[row][column];
                }
                System.out.print(outputSumbol + " ");
            }
            System.out.println();
        }
    }
}