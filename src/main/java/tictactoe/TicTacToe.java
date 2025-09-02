package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        this.board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        this.currentPlayer = 'X';
    }

    public String play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe! The first player to get 3 in a row (vertically, horizontally" +
                "or diagonally) wins.");
        printBoard();
        while (!isBoardFull()) {
            System.out.println("Player " + currentPlayer + "'s turn:");
            System.out.println("Where would you like to place your counter?");
            System.out.println("Enter row and column (e.g. 1 2)");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            if (board[row][column] != ' ') {
                System.out.println("This box has already been filled. Try again!");
                continue;
            }
            board[row][column] = currentPlayer;
            printBoard();
            if (isWinningMove()) {
                return "Congratulations! Player " + currentPlayer + " has won the game!";
            }
            changePlayer();
        }
        return "Game over! As the board is now full, this game ended in a draw.";
    }

    private boolean isWinningMove() {
        //vertical 3 (column 0,1 or 2), horizontal 3 (row 0,1 or 2), diagonal 3 (0,0, 1,1, 2,2 OR 2,0, 1,1, 0,2)
        for (int i = 0; i < board.length; i++) {
            //row win
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
            //column win
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
            //main diagonal win
            if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                return true;
            }
            //anti-diagonal win
            if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                return true;
            }
        }
        return false;
    }

    private void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    private boolean isBoardFull() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < board[i].length - 1) System.out.print("|");
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }
}
