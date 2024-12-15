package com.example;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner; // Add scanner as an instance variable


    public HumanPlayer(String name, String symbol, Scanner scanner) {
        super(name, symbol);
        this.scanner = scanner;
    }

    // Default constructor if no Scanner is needed
    public HumanPlayer(String name, String symbol) {
        super(name, symbol);
        this.scanner = new Scanner(System.in);  // Default to using System.in
    }

    @Override
    public int makeMove(Board board) {
        System.out.print("Add meg az oszlop számát (0-tól kezdve): ");
        return scanner.nextInt();
    }
}
