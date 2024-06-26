package hunarTasks;

import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOn = true;

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");
        System.out.println("Enter your move in the format: row column");

        while (gameOn) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move:");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOn = false;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a tie!");
                    gameOn = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("This spot is already taken. Try again.");
            }
        }

        sc.close();
    }

    public static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2)
                    System.out.print(" | ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("---------");
        }
    }

    public static boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}