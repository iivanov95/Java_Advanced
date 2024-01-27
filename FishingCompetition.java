import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int currentRow = 0;
        int currentCol = 0;
        for (int r = 0; r < n; r++) {
            char[] col = scanner.nextLine().toCharArray();
            matrix[r] = col;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'S') {
                    currentRow = r;
                    currentCol = c;
                }
            }
        }
        String command = scanner.nextLine();
        int tonsFishCollected = 0;
        while (!command.equals("collect the nets")) {
            switch (command) {
                case "up":
                    matrix[currentRow][currentCol] = '-';
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow = matrix.length - 1;
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                            matrix[currentRow][currentCol] = '-';
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    if (Character.isDigit(matrix[currentRow][currentCol])) {
                        tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                    } else if (matrix[currentRow][currentCol] == 'W') {
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]", currentRow, currentCol);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    break;
                case "down":
                    matrix[currentRow][currentCol] = '-';
                    currentRow++;
                    if (currentRow > matrix.length - 1) {
                        currentRow = 0;
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                            matrix[currentRow][currentCol] = '-';
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    if (Character.isDigit(matrix[currentRow][currentCol])) {
                        tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                    } else if (matrix[currentRow][currentCol] == 'W') {
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]", currentRow, currentCol);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    break;
                case "left":
                    matrix[currentRow][currentCol] = '-';
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol = matrix.length - 1;
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                            matrix[currentRow][currentCol] = '-';
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    if (Character.isDigit(matrix[currentRow][currentCol])) {
                        tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                    } else if (matrix[currentRow][currentCol] == 'W') {
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]", currentRow, currentCol);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    break;
                case "right":
                    matrix[currentRow][currentCol] = '-';
                    currentCol++;
                    if (currentCol > matrix.length - 1) {
                        currentCol = 0;
                        if (Character.isDigit(matrix[currentRow][currentCol])) {
                            tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                            matrix[currentRow][currentCol] = '-';
                        }
                        command = scanner.nextLine();
                        continue;
                    }
                    if (Character.isDigit(matrix[currentRow][currentCol])) {
                        tonsFishCollected += Integer.parseInt(matrix[currentRow][currentCol] + "");
                    } else if (matrix[currentRow][currentCol] == 'W') {
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]", currentRow, currentCol);
                        return;
                    }
                    matrix[currentRow][currentCol] = '-';
                    break;
            }
            command = scanner.nextLine();
            if (command.equals("collect the nets")) {
                matrix[currentRow][currentCol] = 'S';
            }
        }
        if (tonsFishCollected >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - tonsFishCollected);
        }
        if (tonsFishCollected > 0) {
            System.out.printf("Amount of fish caught: %d tons.", tonsFishCollected);
        }
        for (int r = 0; r < matrix.length; r++) {
            System.out.println();
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
        }
    }
}