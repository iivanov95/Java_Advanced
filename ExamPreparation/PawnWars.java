package ExamPreparation;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = inputToBoard(scanner);

        boolean whiteToMove = true;

        while (true) {
            if (whiteToMove) {
                String captured = canPawnCapture(board, - 1,'w', 'b');
                if (captured != null) {
                    System.out.println(String.format("Game over! White capture on %s.", captured));
                    break;
                }
                String promoted = movePawnForward(board, - 1, 'w');
                if (promoted != null) {
                    System.out.println(String.format("Game over! White pawn is promoted to a queen at %s.", promoted));
                    break;
                }
            } else {
                String captured = canPawnCapture(board, 1, 'b', 'w');
                if (captured != null) {
                    System.out.println(String.format("Game over! Black capture on %s.", captured));
                    break;
                }
                String promoted = movePawnForward(board, 1, 'b');
                if (promoted != null) {
                    System.out.println(String.format("Game over! Black pawn is promoted to a queen at %s.", promoted));
                    break;
                }
            }
            whiteToMove = !whiteToMove;
        }
    }

    private static String coordinatesToChessNotation (int[] coordinates) {
        int row = 8 - coordinates[0];
        int col = 'a' + coordinates[1];
        return String.format("%c%d", col, row);
    }

    private static String movePawnForward(char[][] board, int direction, char pawn) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == pawn) {
                    if ((r + direction == 0 && pawn == 'w') || (r + direction == 7 && pawn == 'b')) {
                        return coordinatesToChessNotation(new int[]{r + direction, c});
                    }
                    board[r][c] = '-';
                    board[r + direction][c] = pawn;
                    return null;
                }
            }
        }
        return null;
    }

    private static String canPawnCapture(char[][] board, int direction, char pawn, char enemyPawn) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == pawn) {
                    if ((r + direction >= 0 && c - 1 >= 0)
                            && board[r + direction][c - 1] == enemyPawn) {
                        return coordinatesToChessNotation(new int[]{r + direction, c - 1});
                    }
                    if ((r + direction >= 0 && r + direction < board.length
                            && c + 1 < board[r].length)
                            && board[r + direction][c + 1] == enemyPawn) {
                        return coordinatesToChessNotation(new int[]{r + direction, c + 1});
                    }
                    return null;
                }
            }
        }
        return null;
    }

    private static char[][] inputToBoard(Scanner scanner) {
        char[][] board = new char[8][8];
        for (int r = 0; r < board.length; r++) {
            String row = scanner.nextLine();
            board[r] = row.toCharArray();
        }
        return board;
    }
    private static void printBoard(Scanner scanner) {
        char[][] board = new char[8][8];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }
}