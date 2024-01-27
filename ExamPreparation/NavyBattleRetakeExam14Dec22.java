package ExamPreparation;

import java.util.Scanner;

public class NavyBattleRetakeExam14Dec22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] battlefield = new char[n][n];
        int submarineCol = 0;
        int submarineRow = 0;
        for (int r = 0; r < n; r++) {
            char[] row = scanner.nextLine().toCharArray();
            battlefield[r] = row;
            for (int c = 0; c < n; c++) {
                if (battlefield[r][c] == 'S') {
                    submarineRow = r;
                    submarineCol = c;
                }
            }
        }

        int submarineMineHits = 0;
        int submarineCruiserHits = 0;
        while (submarineMineHits < 3 && submarineCruiserHits < 3) {
            String direction = scanner.nextLine();
            battlefield[submarineRow][submarineCol] = '-';
            switch (direction) {
                case "up":
                    submarineRow--;
                    break;
                case "down":
                    submarineRow++;
                    break;
                case "left":
                    submarineCol--;
                    break;
                case "right":
                    submarineCol++;
                    break;
            }
            if (battlefield[submarineRow][submarineCol] == '-') {
                battlefield[submarineRow][submarineCol] = 'S';
            } else if (battlefield[submarineRow][submarineCol] == '*') {
                battlefield[submarineRow][submarineCol] = 'S';
                submarineMineHits++;
            } else if (battlefield[submarineRow][submarineCol] == 'C') {
                battlefield[submarineRow][submarineCol] = 'S';
                submarineCruiserHits++;
            }
        }
        if (submarineMineHits == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
        } else {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }
        printMatrix(battlefield);
    }
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}