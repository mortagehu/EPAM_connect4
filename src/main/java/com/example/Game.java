package com.example;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public Game() {
        board = new Board(6, 7); // 6 rows, 7 columns
        player1 = new HumanPlayer("Gigachad", "X");
        player2 = new Computer("Computer", "O");
    }

    public Game(Board mockBoard, Player mockPlayer1, Player mockPlayer2) {
            this.board = mockBoard;
            this.player1 = mockPlayer1;
            this.player2 = mockPlayer2;
    }

    public void start() {
        Player currentPlayer = player1; // Player 1 starts
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.displayBoard(); // Use the display method to print the board
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), lépj!");

            int column;
            if (currentPlayer instanceof HumanPlayer) {
                System.out.print("Add meg az oszlop számát (0-tól kezdve): ");
                column = scanner.nextInt();
            } else {
                column = currentPlayer.makeMove(board); // Computer player's move
                System.out.println("A gép az oszlopot választotta: " + column);
            }

            if (!board.placeDisk(column, currentPlayer.getSymbol())) {
                System.out.println("Érvénytelen lépés! Próbáld újra.");
                continue;
            }

            if (board.checkWinner(currentPlayer.getSymbol())) {
                board.displayBoard(); // Display the final board
                System.out.println("Gratulálunk, " + currentPlayer.getName() + " nyert!");
                break;
            }

            if (board.isFull()) {
                board.displayBoard(); // Display the board when the game ends
                System.out.println("Döntetlen! A tábla megtelt.");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }
}
