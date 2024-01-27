package ExamPreparation;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energyParis = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        for (int r = 0; r < rows; r++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[r] = row;
        }
        String line = scanner.nextLine();
        while (energyParis > 0) {
            String command = line.split(" ")[0];
            int row = Integer.parseInt(line.split(" ")[1]);
            int col = Integer.parseInt(line.split(" ")[2]);


            line = scanner.nextLine();
        }
    }

}